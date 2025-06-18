package com.lyl.unionpay;

import cn.hutool.json.JSONUtil;
import com.lyl.unionpay.demo.DemoBase;
import com.lyl.unionpay.sdk.QrcService;
import com.lyl.unionpay.sdk.SDKConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


@Slf4j
public class UnionPayDemo {
    private String qrcBackTransUrl="https://c2c.test.95516.com/qrc/api/backTransReq.do";

    /**
     * 深圳工会获取银联二维码
     */
    @Test
    public void getQrCode() {
        Map<String, String> contentData = new HashMap<>();
        contentData.put("version", "1.0.0");
        contentData.put("reqType", "0210000903");//0210000903
        contentData.put("issCode", "90880020");//测试 90880020    生产 49995487
        // contentData.put("signType", QRC_SIGNTYPE_SHA256WITHRSA);
        // contentData.put("signType", "01");
        contentData.put("qrType", "35"); //35借记卡   51 贷记卡   40其他

        //付款方申码交易主键
        contentData.put("qrOrderNo", DemoBase.getOrderId());
        contentData.put("qrOrderTime", DemoBase.getCurrentTime());
        // contentData.put("qrValidTime", "300000");

        // contentData.put("emvCodeIn", emvCodeIn);

        //riskInfo必送，详细参考规范说明
        contentData.put("riskInfo", QrcService.base64Encode("{deviceType=1&mobile=13316739914&accountIdHash=00000002&sourceIP=180.76.48.7}", DemoBase.encoding));

        Map<String, String> payerInfoMap = new HashMap<>();
        payerInfoMap.put("accNo", "6230580000445483022");
        // if(null!=name && !"".equals(name)) payerInfoMap.put("name", name);
        // if(null!=payerBankInfo && !"".equals(payerBankInfo)) payerInfoMap.put("payerBankInfo", payerBankInfo);
        // if(null!=acctClass && !"".equals(acctClass)) payerInfoMap.put("acctClass", acctClass);
        payerInfoMap.put("cardAttr", "01");//01 借记卡 02 贷记卡（含准贷记卡）
        payerInfoMap.put("mobile", "13316739914");//手机号必送
        // payerInfoMap.put("name", "宋小");//姓名

        //如果对机构号issCode 配置了敏感信息加密，必须1.送encryptCertId 2.对payerInfo，payeeInfo的值整体加密
        //目前二维码系统要求所有接入均采用加密方式，使用正式机构号测试的时候参考如下方法上送

        //敏感信息不加密使用DemoBase.getPayerInfo方法   测试用
        contentData.put("payerInfo", DemoBase.getPayerInfo(payerInfoMap,"UTF-8"));

        // contentData.put("payerInfo", DemoBase.getPayerInfoWithEncrpyt(payerInfoMap,"UTF-8"));
        contentData.put("encryptCertId", QrcService.getEncryptCertId());

        // contentData.put("certId", QrcService.());

        // contentData.put("emvCodeIn", "1");

        // if(!"".equals(couponInfo_type) && !"".equals(couponInfo_id)){
        //     String couponInfoStr = "[{\"type\": \"" + couponInfo_type + "\", \"id\" : \"" + couponInfo_id + "\"}]"; //可替换使用第三方json库组json
        //     //付款方适配活动：付款方需要明确指出活动的出资方，允许以下三种情况，即付款方单独出资、付款方与银联共同出资、银联单独出资
        //     contentData.put("couponInfo", QrcService.base64Encode(couponInfoStr,"UTF-8"));
        // }

        // if("".equals(pinFree.trim()) && "".equals(maxAmont.trim()) && "".equals(addnOpUrl.trim()))
        // {
        //     //不送addnCond addnOpUrl
        // }else{
        //     Map<String, String> addnCondMap = new HashMap<String, String>();
        //     addnCondMap.put("currency", "156"); //金额币种
        //     addnCondMap.put("pinFree", pinFree);//免密限额
        //     addnCondMap.put("maxAmont", maxAmont);//最高交易金额
        //     contentData.put("addnCond", DemoBase.getAddnCond(addnCondMap,"UTF-8")); //附加处理条件
        //     contentData.put("addnOpUrl", addnOpUrl);//附加处理服务器地址
        // }
        contentData.put("reqReserved", "reserved"+DemoBase.getOrderId());
        //c2b交易通知发送地址
        contentData.put("backUrl", "https://miniapp-gig.szzgh.org//sim/notify_url2.jsp");
        Map<String, String> reqData = QrcService.sign(contentData,DemoBase.encoding);			 //报文中certId,signature的值是在signData方法中获取并自动赋值的，只要证书配置正确即可。
        String requestUrl = SDKConfig.getConfig().getQrcB2cIssBackTransUrl();
        Map<String, String> rspData = QrcService.post(reqData,requestUrl,DemoBase.encoding);  //
        System.out.println("返回报文\n\n"+ JSONUtil.toJsonStr(rspData));

        if(!rspData.isEmpty()){
            if(QrcService.validate(rspData, DemoBase.encoding)){
                log.info("验证签名成功");
                String respCode = rspData.get("respCode") ;
                if(("00").equals(respCode)){

                }else{
                    //其他应答码为失败请排查原因
                    //TODO
                }
            }else{
                log.error("验证签名失败");
                //TODO 检查验证签名失败的原因
            }
        }else{
            //未返回正确的http状态
            log.error("未获取到返回报文或返回http状态码非200");
        }
    }

    /**
     * 深圳工会对接银联绑卡
     * @param req
     */



}
