package de.test;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * User: dmitry
 * Date: 05.04.12
 * Time: 10:09
 */
public abstract class AbstractDelegatingMap implements Map<String, Serializable>, Serializable {

    private transient Map<String, Serializable> cache;

    @PostConstruct
    public void init() {
        this.cache = initDelegate();
    }

    protected abstract Map<String,Serializable> initDelegate();


    @Override
    public Serializable get(Object key) {
        return this.getCache().get(key);
    }

    @Override
    public Serializable put(String key, Serializable value) {
        return getCache().put(key, value);
    }

    @Override
    public Serializable remove(Object key) {
        return getCache().remove(key);
    }

    @Override
    public void clear() {
        getCache().clear();
    }

    @Override
    public Set<String> keySet() {
        return getCache().keySet();
    }

    @Override
    public Collection<Serializable> values() {
        return getCache().values();
    }

    @Override
    public Set<Entry<String, Serializable>> entrySet() {
        return getCache().entrySet();
    }

    @Override
    public int size() {
        return getCache().size();
    }

    @Override
    public boolean isEmpty() {
        return getCache().isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return getCache().containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return getCache().containsValue(value);
    }

    @Override
    public void putAll(Map<? extends String, ? extends Serializable> m) {
        getCache().putAll(m);
    }

    public Map<String, Serializable> getCache() {
        if (cache == null) {
            this.cache = initDelegate();
        }
        return cache;
    }

    public void setCache(Map<String, Serializable> cache) {
        this.cache = cache;
    }
}
