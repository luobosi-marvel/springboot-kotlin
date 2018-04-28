package com.kotlin.marvel.ske.jest

import com.kotlin.marvel.ske.model.Book
import io.searchbox.client.JestClientFactory
import io.searchbox.client.config.HttpClientConfig
import io.searchbox.client.http.JestHttpClient
import io.searchbox.core.*
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.search.aggregations.AggregationBuilders
import org.elasticsearch.search.builder.SearchSourceBuilder
import org.junit.Before
import org.junit.Test
import java.math.BigDecimal
import java.util.*
import java.util.concurrent.TimeUnit

class JestTest {

    private lateinit var httpClient: JestHttpClient
    /**
     * 索引名称
     */
    private val INDEX_NAME = "bookdb"
    /**
     * 索引类型
     */
    private val INDEX_TYPE = "book"

    @Test
    fun test() {
        println("你好")
    }

    @Before
    fun init() {
        println("开始运行")
        val factory = JestClientFactory()
        factory.setHttpClientConfig(HttpClientConfig
                .Builder("http://192.168.70.138:9200")
                .readTimeout(3000)
                .multiThreaded(true)
                .connTimeout(1000)
                .maxConnectionIdleTime(10, TimeUnit.MINUTES)
                .build())
        // 强转是多么的优雅
        httpClient = factory.`object` as JestHttpClient
    }

    @Test
    fun createAnIndex() {
        println("kotlin")

        println(httpClient)

        addDoc()
    }

    /**
     * 添加一个文档
     */
    private fun addDoc() {
        // 创建一个随机数
        val numReviews = Random().nextInt(1000)
        // 构造一个 document 对象
        val book = Book(11L, "jest client", Arrays.asList("marvel", "jack"), "marvel", "just test jest client", Date(), numReviews)
        // 使用 Index 对象创建索引 index -> type -> document -> id -> build()
        val index = Index.Builder(book).id(book.id.toString()).index(INDEX_NAME).type(INDEX_TYPE).build()
        // 使用 JestHttpClient 执行即可
        val json = httpClient.execute(index).jsonString
        // 打印返回值的结果
        println(json)
    }

    /**
     * 批量新增数据
     */
    @Test
    fun addDocBatchBulk() {
        val book1 = Book(15L, "Beego", Arrays.asList("thor", "jane"), "I need help understanding how the GC-related numbers I'm getting from jmap and jstat relate to the settings I'm passing to java. ", "电子工业出版社", Date(), 175)
        val book2 = Book(16L, "stackoverflow", Arrays.asList("unknown", "marvel"), "I'm starting the app (solr) with the following settings on a sever with 16GB of memory", "机械工业出版社", Date(), 180)
        // 构造 model 数据，将 model 数据都包装成 Index 然后放入 List 中
        val modelList = Arrays.asList(Index.Builder(book1).build(), Index.Builder(book2).build())
        // 构造批量插入的 bulk
        val bulk = Bulk.Builder().defaultIndex(INDEX_NAME).defaultType(INDEX_TYPE).addAction(modelList).build()
        // 执行批量插入操作
        val result = httpClient.execute(bulk)
        // 打印返回结果值
        println(result.jsonString)
    }

    /**
     * 根据文档 id 删除文档
     */
    @Test
    fun deleteDocById() {
        val id = 15L
        // 构造一个 Delete 对象，根据id 删除
        val result = httpClient.execute(Delete.Builder(id.toString())
                .index(INDEX_NAME)
                .type(INDEX_TYPE)
                .build())

        println(result.jsonObject)
    }

    @Test
    fun getDocById() {
        val id = 15L
        // 查询 _id 为 #{id} 的 document
        val get = Get.Builder(INDEX_NAME, id.toString()).type(INDEX_TYPE).build()
        val execute = httpClient.execute(get)
        println(execute.jsonString)

    }

    /**
     * sum 聚合运算
     */
    @Test
    fun sum() {
        // 聚合结果列名称
        val customSumCol = "_sumResultValue"

        val aggregation = AggregationBuilders.sum(customSumCol).field("num_reviews")

        val builder = SearchSourceBuilder()
        val query = QueryBuilders.termQuery("publisher", "unknown")
        builder.query(query).aggregation(aggregation)
        val dsl = builder.toString()
        println(dsl)

        val action = Search.Builder(dsl).addIndex(INDEX_NAME).addType(INDEX_TYPE).build()
        val result = httpClient.execute(action)
        val sum = BigDecimal(result.aggregations.getSumAggregation(customSumCol).sum)
        println(sum)

    }

    /**
     * count 聚合运算
     */
    @Test
    fun count() {
        val builder = SearchSourceBuilder()
        val query = QueryBuilders.termQuery("publisher", "unknown")
        builder.query(query)

        val count = Count.Builder().query(builder.toString()).addIndex(INDEX_NAME).addType(INDEX_TYPE).build()
        println(count.toString())

        val json = httpClient.execute(count).jsonString
        println(json)
    }

    /**
     * 分页查找信息
     */
    @Test
    fun search() {
        val builder = SearchSourceBuilder()
        val query = QueryBuilders.termQuery("publisher", "unknown")
        builder.query(query).from(0).size(10)
        val dsl = builder.toString()
        println(dsl)

        val action = Search.Builder(dsl).addIndex(INDEX_NAME).addType(INDEX_TYPE).build()
        val json = httpClient.execute(action).jsonString
        println(json)
    }

    /**
     * 使用 dsl 语句查询
     */
    @Test
    fun searchByDSL() {
        val dsl = "{\n" +
                "    \"query\": {\n" +
                "        \"term\" : {\n" +
                "            \"publisher\": \"unknown\"\n" +
                "        }\n" +
                "    }\n" +
                "}"

        val action = Search.Builder(dsl).addIndex(INDEX_NAME).addType(INDEX_TYPE).build()
        val json = httpClient.execute(action).jsonString
        println(json)
    }




}