
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
 *         &lt;element name="Get_CodeIsTrueGlobal2Result" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "getCodeIsTrueGlobal2Result",
    "reply"
})
@XmlRootElement(name = "Get_CodeIsTrueGlobal2Response")
public class GetCodeIsTrueGlobal2Response {

    @XmlElement(name = "Get_CodeIsTrueGlobal2Result")
    protected boolean getCodeIsTrueGlobal2Result;
    protected String reply;

    /**
     * 获取getCodeIsTrueGlobal2Result属性的值。
     * 
     */
    public boolean isGetCodeIsTrueGlobal2Result() {
        return getCodeIsTrueGlobal2Result;
    }

    /**
     * 设置getCodeIsTrueGlobal2Result属性的值。
     * 
     */
    public void setGetCodeIsTrueGlobal2Result(boolean value) {
        this.getCodeIsTrueGlobal2Result = value;
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
