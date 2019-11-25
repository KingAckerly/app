package com.lsm.app.controller;

/*import com.lsm.app.entity.Student;
import com.lsm.app.service.StudentRepository;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;*/

/*@RestController
@RequestMapping(value = "/mongo")
public class MongoDBController {

    private static Logger logger = LoggerFactory.getLogger(MongoDBController.class);

    @Autowired
    private MongoTemplate mongotemplate;

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        //创建连接
        MongoClient mongoClient = new MongoClient("localhost", 27111);
        //连接指定数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("lsm");
        //创建集合
        //mongoDatabase.createCollection("springboot");//已经存在的集合再次创建会抛出异常
        //获取集合
        MongoCollection<Document> collection = mongoDatabase.getCollection("springboot");
        //插入文档
        Document document = new Document("title", "MongoDB").
                append("description", "database").
                append("likes", 100).
                append("by", "Fly");
        List<Document> documents = new ArrayList<Document>();
        documents.add(document);
        collection.insertMany(documents);
        //检索所有文档
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()) {
            System.out.println(mongoCursor.next());
        }
        //更新文档   将文档中likes=100的文档修改为likes=200
        collection.updateMany(Filters.eq("likes", 100), new Document("$set", new Document("likes", 200)));
        //重新检索所有文档
        findIterable = collection.find();
        mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()) {
            System.out.println(mongoCursor.next());
        }
        //插入文档
        documents = new ArrayList<Document>();
        document = new Document("title", "MongoDB").
                append("description", "database").
                append("likes", 200).
                append("by", "Fly1");
        documents.add(document);
        document = new Document("title", "MongoDB").
                append("description", "database").
                append("likes", 200).
                append("by", "Fly2");
        documents.add(document);
        collection.insertMany(documents);
        //重新检索所有文档
        findIterable = collection.find();
        mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()) {
            System.out.println(mongoCursor.next());
        }
        return null;
    }

    @RequestMapping(value = "/readByMongoTemplate", method = RequestMethod.GET)
    public String readByMongoTemplate() {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("酒仙"));
        String name = mongotemplate.findOne(query, Student.class).getName();
        return name;
    }

    @RequestMapping(value = "/readByMongoRepository", method = RequestMethod.GET)
    public String readByMongoRepository() {
        String name = studentRepository.findBySex("酒仙").getName();
        return name;
    }


}*/
