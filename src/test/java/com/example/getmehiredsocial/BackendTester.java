package com.example.getmehiredsocial;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import java.io.File;
import java.util.List;

public class BackendTester {
    public static void main(String[] args) {
    System.out.println("Hello Class....");

        AWSCredentials credentials = new BasicAWSCredentials(
                "AKIAWKNZN4OVBG443NBE",
                "qNTcA8AKmqJPSHGBmccPsy5gskotpOF4H2FRY6W4"
        );

        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2)
                .build();

        //List<Bucket> buckets = s3client.listBuckets();
        //for(Bucket bucket : buckets) {
          //  System.out.println(bucket.getName());
        //}

        s3client.putObject(
                "backend-class",
                "setting.txt",
                new File("D:/setting.txt")
        );

        ObjectListing objectListing = s3client.listObjects("backend-class");
        for(S3ObjectSummary os : objectListing.getObjectSummaries()) {
            System.out.println(os.getKey());
        }

        s3client.deleteObject("backend-class","setting.txt");

    //backend-class
    //AKIAWKNZN4OVBG443NBE
    //qNTcA8AKmqJPSHGBmccPsy5gskotpOF4H2FRY6W4
    }

}
