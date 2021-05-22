package com.mongodb.quickstart;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.descending;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Read {

    public boolean readUser(String username, String password) {
        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://Shivang:ZSbhhO7RfY9VitJB@cluster0.5fbiw.mongodb.net/testDatabase?retryWrites=true&w=majority")) {
            MongoDatabase beswaadDB = mongoClient.getDatabase("beswaad");
            MongoCollection<Document> usersCollection = beswaadDB.getCollection("users");

            // find one document with new Document
//            Document student1 = gradesCollection.find(new Document("student_id", 10000)).first();
//            System.out.println("Student 1: " + student1.toJson());

            // find one document with Filters.eq()
            Document userData = usersCollection.find(eq("username", username)).first();
            if (userData == null) {
                System.out.println("No user found with that username!\n(Try another username --- OR --- Create a new account)");
                return false;
            } else {
                String userDataStr = userData.toJson();
                String splittedUserDataStr = userDataStr.split("\"password\": \"")[1];
                String dbPassword = splittedUserDataStr.substring(0, splittedUserDataStr.length()-2);
                if(dbPassword.equals(password)){
                    return true;
                }
                else{
                    System.out.println("Wrong Password!");
                    return false;
                }
            }

            // find a list of documents and iterate throw it using an iterator.
//            FindIterable<Document> iterable = gradesCollection.find(gte("student_id", 10000));
//            MongoCursor<Document> cursor = iterable.iterator();
//            System.out.println("Student list with a cursor: ");
//            while (cursor.hasNext()) {
//                System.out.println(cursor.next().toJson());
//            }

            // find a list of documents and use a List object instead of an iterator
//            List<Document> studentList = gradesCollection.find(gte("student_id", 10000)).into(new ArrayList<>());
//            System.out.println("Student list with an ArrayList:");
//            for (Document student : studentList) {
//                System.out.println(student.toJson());
//            }

            // find a list of documents and print using a consumer
//            System.out.println("Student list using a Consumer:");
//            Consumer<Document> printConsumer = document -> System.out.println(document.toJson());
//            gradesCollection.find(gte("student_id", 10000)).forEach(printConsumer);

            // find a list of documents with sort, skip, limit and projection
//            List<Document> docs = gradesCollection.find(and(eq("student_id", 10001), lte("class_id", 5)))
//                                                  .projection(fields(excludeId(), include("class_id", "student_id")))
//                                                  .sort(descending("class_id"))
//                                                  .skip(2)
//                                                  .limit(2)
//                                                  .into(new ArrayList<>());
//
//            System.out.println("Student sorted, skipped, limited and projected: ");
//            for (Document student : docs) {
//                System.out.println(student.toJson());
//            }
        }
    }

    public void adminRevenue(){
        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://Shivang:ZSbhhO7RfY9VitJB@cluster0.5fbiw.mongodb.net/testDatabase?retryWrites=true&w=majority")) {
            MongoDatabase beswaadDB = mongoClient.getDatabase("beswaad");
            MongoCollection<Document> revenueCollection = beswaadDB.getCollection("revenue");

            MongoCursor<Document> cur = revenueCollection.find().iterator();

            while(cur.hasNext()){
                String a = cur.next().toJson();
                JSONParser parser = new JSONParser();
                try {
                    JSONObject json = (JSONObject) parser.parse(a);
                    System.out.print(json.get("type") + "\t" + json.get("earnings") + "\t");
                }
                catch (Exception e) {
                    System.out.println("Error parsing");
                }
            }
            System.out.println();
        }
    }
}
