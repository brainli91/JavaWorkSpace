package com.fdmgroup;

public interface CatalogueId<T extends Number> {
       T generateId();
       T getId();
}
