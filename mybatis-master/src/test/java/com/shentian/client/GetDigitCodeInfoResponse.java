
package com.shentian.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetDigitCodeInfoResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="systemState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reply" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstQueryDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="queryCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productInfo" type="{http://fw.yesno.com.cn/CCNCommonService}ArrayOfString" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getDigitCodeInfoResult",
    "systemState",
    "reply",
    "firstQueryDate",
    "queryCount",
    "productInfo"
})
@XmlRootElement(name = "GetDigitCodeInfoResponse")
public class GetDigitCodeInfoResponse {

    @XmlElement(name = "GetDigitCodeInfoResult")
    protected boolean getDigitCodeInfoResult;
    protected String systemState;
    protected String reply;
    protected String firstQueryDate;
    protected String queryCount;
    protected ArrayOfString productInfo;

    /**
     * 获取getDigitCodeInfoResult属性的值。
     * 
     */
    public boolean isGetDigitCodeInfoResult() {
        return getDigitCodeInfoResult;
    }

    /**
     * 设置getDigitCodeInfoResult属性的值。
     * 
     */
    public void setGetDigitCodeInfoResult(boolean value) {
        this.getDigitCodeInfoResult = value;
    }

    /**
     * 获取systemState属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemState() {
        return systemState;
    }

    /**
     * 设置systemState属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemState(String value) {
        this.systemState = value;
    }

    /**
     * 获取reply属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReply() {
        return reply;
    }

    /**
     * 设置reply属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReply(String value) {
        this.reply = value;
    }

    /**
     * 获取firstQueryDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstQueryDate() {
        return firstQueryDate;
    }

    /**
     * 设置firstQueryDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstQueryDate(String value) {
        this.firstQueryDate = value;
    }

    /**
     * 获取queryCount属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryCount() {
        return queryCount;
    }

    /**
     * 设置queryCount属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryCount(String value) {
        this.queryCount = value;
    }

    /**
     * 获取productInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getProductInfo() {
        return productInfo;
    }

    /**
     * 设置productInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setProductInfo(ArrayOfString value) {
        this.productInfo = value;
    }

}
