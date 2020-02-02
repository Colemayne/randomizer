package com.coleman.randomizer.controller;

import com.coleman.randomizer.domain.Model;
import com.coleman.randomizer.utils.ElasticUtils;
import com.coleman.randomizer.utils.RandomUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/elastic/v1")
public class ElasticController {
    @Autowired
    private RandomUtils randomUtils;
    @Autowired
    private ElasticUtils elasticUtils;

    @GetMapping("/add")
    public void addRandom() throws IOException {

        Model model = new Model(randomUtils.randomFirstName(), randomUtils.randomLastName(), randomUtils.randomLastName(),
                randomUtils.randomNumber(5), randomUtils.randomAddress(), randomUtils.randomDate(), randomUtils.randomDate(),
                randomUtils.randomNumber(5), randomUtils.randomFirstName() + " " + randomUtils.randomLastName(),
                randomUtils.randomAddress(), randomUtils.randomDataset());

        elasticUtils.addDocument(model);

    }

    @PostMapping("/update/{id}")
    public void updateRandom(@PathVariable String id) throws IOException {
        Model model = new Model(randomUtils.randomFirstName(), randomUtils.randomLastName(), randomUtils.randomLastName(),
                Integer.valueOf(id), randomUtils.randomAddress(), randomUtils.randomDate(), randomUtils.randomDate(),
                randomUtils.randomNumber(5), randomUtils.randomFirstName() + " " + randomUtils.randomLastName(),
                randomUtils.randomAddress(), randomUtils.randomDataset());

        elasticUtils.addDocument(model);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDocument(@PathVariable String id) throws IOException{
        elasticUtils.deleteDocument(id);
    }

    /*
     Sample for queries.
     can provide a parameter to search by "dataset"
     Otherwise this will return everything!
     */
    @GetMapping("/search")
    public List<Model> searchDocument(@RequestParam Optional<String> dataset) throws IOException {
        if(dataset.isPresent()) {
            return elasticUtils.searchDocument(dataset.get());
        } else {
            return elasticUtils.allDocuments();
        }
    }

    @GetMapping("/search/count")
    public Long searchDocumentForNumber(@RequestParam Optional<String> dataset) throws IOException {
        List<Model> models;
        if(dataset.isPresent()) {
            models = elasticUtils.searchDocument(dataset.get());
        } else {
            models = elasticUtils.allDocuments();
        }
        return (long) models.size();
    }

}
