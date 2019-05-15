package com.hyl.core.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.*;

public class CreateEnumUtils {
    public static void main(String[] args) throws Exception {
        Map<String, Object> map =new HashMap<>();
        List<enumObject> list = new ArrayList<>();
        list.add(new enumObject("AccountTypeEnum", "账户类型"));
        list.add(new enumObject("ActiveStateEnum", "活动状态"));
        list.add(new enumObject("CardTypeEnum", "银行卡类型"));
        list.add(new enumObject("CurrencyEnum", "交易币种"));
        list.add(new enumObject("FeeTypeEnum", "交易手续费费率收取类别"));
        list.add(new enumObject("TransactionObjectTypeEnum", "交易的主体类型"));
        list.add(new enumObject("TransactionTypeEnum", "交易类型"));
        list.add(new enumObject("MerchantGradeEnum", "商户等级或代理等级"));
        list.add(new enumObject("RegisterStateEnum", "审核状态"));
        list.add(new enumObject("PaymentStatusEnum", "订单的交易状态"));
        map.put("enumList",list);

        /* 生成enum的Service */
        printFile("enumServiceTemplate.ftl", map, "CommonEnumService.java", "\\query\\");
        printFile("enumServiceImplTemplate.ftl", map, "CommonEnumServiceImpl.java", "\\query\\");

        System.out.println("生成完毕！");
    }

    public static void printFile(String ftlName, Map<String, Object> root, String outFile, String filePath) throws Exception {
        try {
            File file = new File("C:\\createCode\\" + filePath + outFile);
            if (!file.getParentFile().exists()) { // 判断有没有父路径，就是判断文件整个路径是否存在
                file.getParentFile().mkdirs(); // 不存在就全部创建
            }
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
            Template template = getTemplate(ftlName);
            template.process(root, out); // 模版输出
            out.flush();
            out.close();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过文件名加载模版
     *
     * @param ftlName
     */
    public static Template getTemplate(String ftlName) throws Exception {
        try {
            Configuration cfg = new Configuration(); // 通过Freemaker的Configuration读取相应的ftl
            cfg.setEncoding(Locale.CHINA, "utf-8");
            cfg.setDirectoryForTemplateLoading(new File(System.getProperty("user.dir")+ "\\core\\src\\main\\java\\com\\hyl\\core\\util\\template\\")); // 设定去哪里读取相应的ftl模板文件
            Template temp = cfg.getTemplate(ftlName); // 在模板文件目录中找到名称为name的文件
            return temp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static class enumObject implements Serializable {
        private String name;
        private String memo;

        public enumObject(String name, String memo) {
            this.name = name;
            this.memo = memo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }
    }
}
