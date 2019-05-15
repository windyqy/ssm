
import java.util.List;

/**
 * Copyright glbpay.com
 * Created by Xu Qihua on 2019/3/31.
 * Descripton: 枚举公共类
 */
public interface CommonEnumService {
    <#if enumList??>
        asd
    <#list enumList as e>
    /**
        ${e}
     * ${e.memo}
     * @return
     */
    List<${e.name}> ${"get" + e.name + "s"}();
    </#list>
    </#if>
}
