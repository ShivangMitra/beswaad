package com.mongodb.quickstart;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;

public class Delete {

    public void deleteItem(String itemName) {
        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://Shivang:ZSbhhO7RfY9VitJB@cluster0.5fbiw.mongodb.net/testDatabase?retryWrites=true&w=majority")) {
            MongoDatabase beswaadDB = mongoClient.getDatabase("beswaad");
            MongoCollection<Document> menuCollection = beswaadDB.getCollection("menu");

            // delete one document
            Bson filter = eq("name", itemName);
            DeleteResult result = menuCollection.deleteOne(filter);

            System.out.println(itemName + " has been removed from the menu");

//            // findOneAndDelete operation
//            filter = eq("student_id", 10002);
//            Document doc = gradesCollection.findOneAndDelete(filter);
//            System.out.println(doc.toJson(JsonWriterSettings.builder().indent(true).build()));
//
//            // delete many documents
//            filter = gte("student_id", 10000);
//            result = gradesCollection.deleteMany(filter);
//            System.out.println(result);
//
//            // delete the entire collection and its metadata (indexes, chunk metadata, etc).
//            gradesCollection.drop();
        }
    }
}
