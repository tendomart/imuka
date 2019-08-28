package com.imuka.imuka.Util;

import org.springframework.data.domain.Page;


public class Pager<Items> {
	 private final Page<Items> items;

	    public Pager(Page<Items> items) {
	        this.items = items;
	    }

	    public int getPageIndex() {
	        return items.getNumber() + 1;
	    }

	    public int getPageSize() {
	        return items.getSize();
	    }

	    public boolean hasNext() {
	        return items.hasNext();
	    }

	    public boolean hasPrevious() {
	        return items.hasPrevious();
	    }

	    public int getTotalPages() {
	        return items.getTotalPages();
	    }

	    public long getTotalElements() {
	        return items.getTotalElements();
	    }

	    public boolean indexOutOfBounds() {
	        return this.getPageIndex() < 0 || this.getPageIndex() > this.getTotalElements();
	    }

}
