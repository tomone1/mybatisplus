
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
 *         &lt;element name="Get_CodeIsTrueByChannelResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="reply" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="systemState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getCodeIsTrueByChannelResult",
    "reply",
    "systemState"
})
@XmlRootElement(name = "Get_CodeIsTrueByChannelResponse")
public class GetCodeIsTrueByChannelResponse {

    @XmlElement(name = "Get_CodeIsTrueByChannelResult")
    protected boolean getCodeIsTrueByChannelResult;
    protected String reply;
    protected String systemState;

    /**
     * 获取getCodeIsTrueByChannelResult属性的值。
     * 
     */
    public boolean isGetCodeIsTrueByChannelResult() {
        return getCodeIsTrueByChannelResult;
    }

    /**
     * 设置getCodeIsTrueByChannelResult属性的值。
     * 
     */
    public void setGetCodeIsTrueByChannelResult(boolean value) {
        this.getCodeIsTrueByChannelResult = value;
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

}