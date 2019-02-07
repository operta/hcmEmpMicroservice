package com.infostudio.ba.web.rest.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Utility class for handling pagination.
 *
 * <p>
 * Pagination uses the same principles as the <a href="https://developer.github.com/v3/#pagination">GitHub API</a>,
 * and follow <a href="http://tools.ietf.org/html/rfc5988">RFC 5988 (Link header)</a>.
 */
public final class PaginationUtil {

    private PaginationUtil() {
    }

    public static HttpHeaders generatePaginationHttpHeaders(Page page, String baseUrl) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", Long.toString(page.getTotalElements()));
        String link = "";
        if ((page.getNumber() + 1) < page.getTotalPages()) {
            link = "<" + generateUri(baseUrl, page.getNumber() + 1, page.getSize()) + ">; rel=\"next\",";
        }
        // prev link
        if ((page.getNumber()) > 0) {
            link += "<" + generateUri(baseUrl, page.getNumber() - 1, page.getSize()) + ">; rel=\"prev\",";
        }
        // last and first link
        int lastPage = 0;
        if (page.getTotalPages() > 0) {
            lastPage = page.getTotalPages() - 1;
        }
        link += "<" + generateUri(baseUrl, lastPage, page.getSize()) + ">; rel=\"last\",";
        link += "<" + generateUri(baseUrl, 0, page.getSize()) + ">; rel=\"first\"";
        headers.add(HttpHeaders.LINK, link);
        return headers;
    }

    public static HttpHeaders generatePaginationHttpHeadersForSearchEndpoint(Page page, String baseUrl,
                                                                             Map<String, String> uriParams) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", Long.toString(page.getTotalElements()));
        StringBuilder link = new StringBuilder();
        if ((page.getNumber() + 1) < page.getTotalPages()) {
            link.append("<").append(generateUri(baseUrl, page.getNumber() + 1, page.getSize()));
            link = appendUriParams(link, uriParams);
            link.append(">; rel=\"next\",");
        }
        if (page.getNumber() > 0) {
            link.append("<").append(generateUri(baseUrl, page.getNumber() - 1, page.getSize()));
            link = appendUriParams(link, uriParams);
            link.append(">; rel=\"prev\",");
        }
        int lastPage = 0;
        if (page.getTotalPages() > 0) {
            lastPage = page.getTotalPages() - 1;
        }
        link.append("<").append(generateUri(baseUrl, lastPage, page.getSize()));
        link = appendUriParams(link, uriParams);
        link.append(">; rel=\"last\",");
        link.append("<").append(generateUri(baseUrl, 0, page.getSize()));
        link = appendUriParams(link, uriParams);
        link.append(">; rel=\"first\"");
        headers.add(HttpHeaders.LINK, link.toString());
        return headers;
    }

    private static StringBuilder appendUriParams(StringBuilder link, Map<String, String> uriParams) {
        for (Map.Entry<String, String> uriParam : uriParams.entrySet()) {
            link.append("&").append(uriParam.getKey()).append("=").append(uriParam.getValue());
        }
        return link;
    }

    private static String generateUri(String baseUrl, int page, int size) {
        return UriComponentsBuilder.fromUriString(baseUrl).queryParam("page", page).queryParam("size", size).toUriString();
    }

    public static <T> Page<T> createPageFromList(List<T> list, Pageable pageable) {
        if (list == null) {
            throw new IllegalArgumentException("List must not be null.");
        }
        int startOfPage = pageable.getPageNumber() * pageable.getPageSize();
        if (startOfPage > list.size()) {
            return new PageImpl<>(new ArrayList<>(), pageable, 0);
        }
        int endOfPage = startOfPage + pageable.getPageSize() > list.size() ? list.size() : startOfPage + pageable.getPageSize();
        return new PageImpl<>(list.subList(startOfPage, endOfPage), pageable, list.size());
    }
}
