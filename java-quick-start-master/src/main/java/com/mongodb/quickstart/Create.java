package com.mongodb.quickstart;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertManyOptions;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class Create {

//    private static final Random rand = new Random();

    String username, password;

    public void createUser(String username,String password) {

        this.username = username;
        this.password = password;

        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://Shivang:ZSbhhO7RfY9VitJB@cluster0.5fbiw.mongodb.net/testDatabase?retryWrites=true&w=majority")) {

            MongoDatabase beswaadDB = mongoClient.getDatabase("beswaad");
            MongoCollection<Document> usersCollection = beswaadDB.getCollection("users");

            insertOneDocument(usersCollection);
//            insertManyDocuments(gradesCollection);
        }
    }

    private void insertOneDocument(MongoCollection<Document> usersCollection) {
        usersCollection.insertOne(generateNewUser(username, password));
        System.out.println("One user inserted for username " + username + " and password " + password);
    }

//    private static void insertManyDocuments(MongoCollection<Document> gradesCollection) {
//        List<Document> grades = new ArrayList<>();
//        for (double classId = 1d; classId <= 10d; classId++) {
//            grades.add(generateNewGrade(10001d, classId));
//        }
//
//        gradesCollection.insertMany(grades, new InsertManyOptions().ordered(false));
//        System.out.println("Ten grades inserted for studentId 10001.");
//    }

//    private static Document generateNewGrade(double studentId, double classId) {
//        List<Document> scores = asList(new Document("type", "exam").append("score", rand.nextDouble() * 100),
//                                       new Document("type", "quiz").append("score", rand.nextDouble() * 100),
//                                       new Document("type", "homework").append("score", rand.nextDouble() * 100),
//                                       new Document("type", "homework").append("score", rand.nextDouble() * 100));
//        return new Document("_id", new ObjectId()).append("student_id", studentId)
//                                                  .append("class_id", classId)
//                                                  .append("scores", scores);
//    }

    private static Document generateNewUser(String username, String password) {
        return new Document("_id", new ObjectId()).append("username", username)
                                                  .append("password", password);
    }
}
