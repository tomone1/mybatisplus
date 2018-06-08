
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
 *         &lt;element name="QueryCodeTrueOrFalseGlobalResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="reply" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "queryCodeTrueOrFalseGlobalResult",
    "reply"
})
@XmlRootElement(name = "QueryCodeTrueOrFalseGlobalResponse")
public class QueryCodeTrueOrFalseGlobalResponse {

    @XmlElement(name = "QueryCodeTrueOrFalseGlobalResult")
    protected boolean queryCodeTrueOrFalseGlobalResult;
    protected String reply;

    /**
     * 获取queryCodeTrueOrFalseGlobalResult属性的值。
     * 
     */
    public boolean isQueryCodeTrueOrFalseGlobalResult() {
        return queryCodeTrueOrFalseGlobalResult;
    }

    /**
     * 设置queryCodeTrueOrFalseGlobalResult属性的值。
     * 
     */
    public void setQueryCodeTrueOrFalseGlobalResult(boolean value) {
        this.queryCodeTrueOrFalseGlobalResult = value;
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

}
