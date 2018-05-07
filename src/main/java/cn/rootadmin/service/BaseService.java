package cn.rootadmin.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.rootadmin.pojo.BasePojo;

import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;

public abstract class BaseService<T extends BasePojo> {


    @Autowired
    private Mapper<T> mapper;

    public Mapper<T> getMapper() {
        return mapper;
    }

    /**
     * 根据id查询数据
     * 
     * @param id
     * @return
     */
    public T queryById(Integer id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有数据
     * 
     * @return
     */
    public List<T> queryAll() {
        return this.mapper.select(null);
    }

    /**
     * 根据条件查询一条数据，如果有多条会抛出异常
     * 
     * @param record
     * @return
     */
    public T queryOne(T record) {
        return this.mapper.selectOne(record);
    }

    /**
     * 根据条件查询数据列表
     * 
     * @param record
     * @return
     */
    public List<T> queryListByWhere(T record) {
        return this.mapper.select(record);
    }


    /**
     * 新增数据，设置数据的创建时间和更新时间
     * 
     * @param t
     * @return
     */
    public Integer save(T t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(t.getCreateTime());
        return this.mapper.insert(t);
    }

    /**
     * 新增(有选择的，选择不为null的字段插入)数据，设置数据的创建时间和更新时间
     * 
     * @param t
     * @return
     */
    public Integer saveSelective(T t) {
        t.setCreateTime(new Date());
        t.setUpdateTime(t.getCreateTime());
        return this.mapper.insertSelective(t);
    }

    /**
     * 更新数据，设置数据的更新时间
     * 
     * @param t
     * @return
     */
    public Integer update(T t) {
        t.setUpdateTime(new Date());
        return this.mapper.updateByPrimaryKey(t);
    }

    /**
     * 更新(有选择的，选择不为null的字段更新)数据，设置数据的更新时间
     * 
     * @param t
     * @return
     */
    public Integer updateSelective(T t) {
        t.setUpdateTime(new Date());
        int i = this.mapper.updateByPrimaryKeySelective(t);
        return i;
    }

    /**
     * 根据id删除数据
     * 
     * @param id
     * @return
     */
    public Integer deleteById(Long id) {
        return this.mapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除数据
     * 
     * @param clazz
     * @param property
     * @param values
     * @return
     */
    public Integer deleteByIds(Class<T> clazz, String property, List<Object> values) {
        Example example = new Example(clazz);
        example.createCriteria().andIn(property, values);
        return this.mapper.deleteByExample(example);
    }

    /**
     * 根据条件删除数据
     * 
     * @param record
     * @return
     */
    public Integer deleteByWhere(T record) {
        return this.mapper.delete(record);
    }

}
