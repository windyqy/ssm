public interface ${entity + "Service"} {

    /**
     * 统计记录行数
     * @param sql
     * @return
     * @throws BizException
     */
    int count(String sql) throws BizException;

    /**
     * 分页查询
     * @param query
     * @return
     * @throws BizException
     */
    Page<${entity + "Model"}> selectByPage(${entity + "Query"} query) throws BizException;

    /**
     * 根据当前表编号查询
     * @param accountIds
     * @return
     * @throws BizException
    */
    List<${entity + "Model"}> selectByIds(String ids) throws BizException;
}
