package com.coleman.randomizer.utils;

import com.coleman.randomizer.domain.Model;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ElasticUtils {

    @Value("${elasticsearch.index}")
    private String elasticIndex;

    @Value("${elasticsearch.search.size}")
    private Integer elasticSearchBuilderSize;

    @Autowired
    private RestHighLevelClient client;

    public String addDocument(Model model) throws IOException {
        IndexRequest request = new IndexRequest(elasticIndex);
        request.id(Integer.toString(model.getEmployeeId()));
        request.source(new ObjectMapper().writeValueAsString(model), XContentType.JSON);
        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
        return indexResponse.getId();
    }

    public String deleteDocument(String id) throws IOException {
        DeleteRequest request = new DeleteRequest(elasticIndex, id);
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        return response.getId();
    }

    public List<Model> allDocuments() throws IOException {
        List<Model> models = new ArrayList<>();
        SearchRequest request = new SearchRequest(elasticIndex);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        request.source(searchSourceBuilder);
        searchSourceBuilder.size(elasticSearchBuilderSize);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        for(SearchHit searchHit: response.getHits().getHits()) {
            Model model = new ObjectMapper().readValue(searchHit.getSourceAsString(),Model.class);
            models.add(model);
        }
        return models;
    }

    public List<Model> searchDocument(String dataset) throws IOException {
        List<Model> models = new ArrayList<>();
        SearchRequest request = new SearchRequest(elasticIndex);
        QueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("dataset", dataset).fuzziness(Fuzziness.AUTO)
                .prefixLength(2)
                .maxExpansions(10);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(matchQueryBuilder);
        request.source(sourceBuilder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        for(SearchHit searchHit: response.getHits().getHits()) {
            Model model = new ObjectMapper().readValue(searchHit.getSourceAsString(),Model.class);
            models.add(model);
        }
        return models;
    }
}
