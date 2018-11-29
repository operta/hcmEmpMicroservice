package com.infostudio.ba.service.proxy;

import com.infostudio.ba.service.proxy.model.OgOrgWorkPlaces;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "hcmCoreMicroservice")
public interface CoreMicroserviceProxy {

    @DeleteMapping("/api/dm-document-links/{id}")
    void deleteDmDocumentLink(@PathVariable(value = "id") Long id, @RequestHeader("Authorization") String auth);

    @GetMapping("/api/og-org-work-places/{id}")
    ResponseEntity<OgOrgWorkPlaces> getOgOrgWorkPlaceById(@PathVariable(value = "id") Long id, @RequestHeader("Authorization") String auth);
}
