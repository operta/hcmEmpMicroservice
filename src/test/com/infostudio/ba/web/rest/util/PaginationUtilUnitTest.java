package com.infostudio.ba.web.rest.util;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class PaginationUtilUnitTest {

    private final Pageable DEFAULT_PAGEABLE = new PageRequest(0, 20);

    private List<Integer> content;

    @Before
    public void setup() {
        content = new ArrayList<>();
    }

    @Test
    public void generatePageFromListTestShouldCreatePage() {
        content.add(1);
        content.add(2);
        content.add(3);


        Page<Integer> page = PaginationUtil.generatePageFromList(content, DEFAULT_PAGEABLE);

        assertNotNull(page);
        assertEquals(20, page.getSize());
        assertEquals(3, page.getTotalElements());
        assertEquals(1, page.getTotalPages());
    }

    @Test
    public void generatePageFromListShouldCreatePageWithTwoTotalPages() {
        for (int i = 0; i < 40; i++) {
            content.add(i);
        }

        Page<Integer> page = PaginationUtil.generatePageFromList(content, DEFAULT_PAGEABLE);

        assertNotNull(page);
        assertEquals(20, page.getSize());
        assertEquals(40, page.getTotalElements());
        assertEquals(2, page.getTotalPages());
    }

    @Test(expected = IllegalArgumentException.class)
    public void generatePageFromListShouldThrowIllegalArgumentExceptionIfListNull() {
        PaginationUtil.generatePageFromList(null, DEFAULT_PAGEABLE);
    }
}
