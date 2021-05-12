package com.aqselmo.s3;

import java.io.File;

import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class Main {
    public static void main(String[] args) {
        AmazonS3 s3client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("", "")))
                .withRegion(Regions.US_EAST_1).build();

        try {
            if (!s3client.doesBucketExist("")) {
                s3client.createBucket(new CreateBucketRequest(""));
            }

            File file = new File("");

            s3client.putObject(new PutObjectRequest("", "", file));

            System.out.println(file.getName());
        } catch (SdkClientException e) {
            System.out.println(e.getMessage());
        }
    }
}
