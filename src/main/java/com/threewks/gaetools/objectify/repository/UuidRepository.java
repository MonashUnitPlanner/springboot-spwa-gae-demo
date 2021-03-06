/*
 * This file is a component of thundr, a software library from 3wks.
 * Read more: http://3wks.github.io/thundr/
 * Copyright (C) 2015 3wks, <thundr@3wks.com.au>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.threewks.gaetools.objectify.repository;

import com.atomicleopard.expressive.ETransformer;
import com.googlecode.objectify.Key;
import com.threewks.gaetools.search.gae.SearchConfig;

import java.util.UUID;

public class UuidRepository<E> extends AbstractRepository<E, UUID> {

    public UuidRepository(final Class<E> entityType, SearchConfig searchConfig) {
        super(entityType, fromUuid(entityType), toUuid(entityType), searchConfig);
    }

    static <E> ETransformer<UUID, Key<E>> fromUuid(final Class<E> type) {
        return from -> Key.create(type, from.toString());
    }

    static <E> ETransformer<Key<E>, UUID> toUuid(final Class<E> type) {
        return from -> UUID.fromString(from.getName());
    }

    protected Key<E> fromWebSafeKey(String key) {
        Key<E> k = Key.create(key);
        return k;
    }
}
