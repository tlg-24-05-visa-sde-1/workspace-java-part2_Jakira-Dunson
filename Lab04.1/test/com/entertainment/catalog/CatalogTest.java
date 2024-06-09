/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.Map;
import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {

    @Test
    public void findByBrands_shouldReturnPopulatedMap_brandsPassed() {
        Map<String,Collection<Television>> televisionMap = Catalog.findByBrands("Sony", "NOT-FOUND");

        assertEquals(2, televisionMap.size());

        Collection<Television> sonyTvs = televisionMap.get("Sony");
        assertEquals(7, sonyTvs.size());
        for (Television tv : sonyTvs) {
            assertEquals("Sony", tv.getBrand());
        }

        Collection<Television> notFoundTvs = televisionMap.get("NOT-FOUND");
        assertTrue(notFoundTvs.isEmpty());
    }

    @Test
    public void findByBrands_shouldReturnEmptyMap_noBrandsPassed() {
        Map<String,Collection<Television>> televisionMap = Catalog.findByBrands();

        assertTrue(televisionMap.isEmpty());
    }

    @Test
    public void findByBrand_shouldReturnPopulatedCollection_brandFound() {
        Collection<Television> televisions = Catalog.findByBrand("Sony");

        assertEquals(7, televisions.size());
        for (Television tv : televisions) {
            assertEquals("Sony", tv.getBrand());
        }
    }

    /**
     * Contract: a no-matches result should be an empty collection (not null).
     */
    @Test
    public void findByBrand_shouldReturnEmptyCollection_brandNotFound() {
        Collection<Television> televisions = Catalog.findByBrand("NO-MATCHES");
        assertNotNull(televisions);
        assertTrue(televisions.isEmpty());
    }
}