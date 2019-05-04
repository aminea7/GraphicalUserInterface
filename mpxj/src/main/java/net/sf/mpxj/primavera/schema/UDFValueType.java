//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2017.09.18 at 02:35:45 PM BST
//

package net.sf.mpxj.primavera.schema;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>Java class for UDFValueType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="UDFValueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CodeValue" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="60"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ConditionalIndicator" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Cost" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="CreateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="CreateUser" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Description" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Double" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *               &lt;minInclusive value="-1.0E12"/>
 *               &lt;maxInclusive value="1.0E12"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FinishDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ForeignObjectId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Indicator" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value=""/>
 *               &lt;enumeration value="None"/>
 *               &lt;enumeration value="Red"/>
 *               &lt;enumeration value="Yellow"/>
 *               &lt;enumeration value="Green"/>
 *               &lt;enumeration value="Blue"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Integer" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="IsBaseline" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsTemplate" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsUDFTypeCalculated" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsUDFTypeConditional" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LastUpdateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="LastUpdateUser" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ProjectObjectId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Text" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="UDFCodeObjectId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="UDFTypeDataType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Text"/>
 *               &lt;enumeration value="Start Date"/>
 *               &lt;enumeration value="Finish Date"/>
 *               &lt;enumeration value="Cost"/>
 *               &lt;enumeration value="Double"/>
 *               &lt;enumeration value="Integer"/>
 *               &lt;enumeration value="Indicator"/>
 *               &lt;enumeration value="Code"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="UDFTypeObjectId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="UDFTypeSubjectArea" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Activity"/>
 *               &lt;enumeration value="Activity Expense"/>
 *               &lt;enumeration value="Activity Step"/>
 *               &lt;enumeration value="Project"/>
 *               &lt;enumeration value="Project Issue"/>
 *               &lt;enumeration value="Project Risk"/>
 *               &lt;enumeration value="Resource"/>
 *               &lt;enumeration value="Resource Assignment"/>
 *               &lt;enumeration value="WBS"/>
 *               &lt;enumeration value="Work Products and Documents"/>
 *               &lt;enumeration value="Activity Step Template Item"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="UDFTypeTitle" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD) @XmlType(name = "UDFValueType", propOrder =
{
   "codeValue",
   "conditionalIndicator",
   "cost",
   "createDate",
   "createUser",
   "description",
   "_double",
   "finishDate",
   "foreignObjectId",
   "indicator",
   "integer",
   "isBaseline",
   "isTemplate",
   "isUDFTypeCalculated",
   "isUDFTypeConditional",
   "lastUpdateDate",
   "lastUpdateUser",
   "projectObjectId",
   "startDate",
   "text",
   "udfCodeObjectId",
   "udfTypeDataType",
   "udfTypeObjectId",
   "udfTypeSubjectArea",
   "udfTypeTitle"
}) public class UDFValueType
{

   @XmlElement(name = "CodeValue") protected String codeValue;
   @XmlElement(name = "ConditionalIndicator", nillable = true) protected Integer conditionalIndicator;
   @XmlElement(name = "Cost", nillable = true) protected Double cost;
   @XmlElement(name = "CreateDate", type = String.class, nillable = true) @XmlJavaTypeAdapter(Adapter1.class) @XmlSchemaType(name = "dateTime") protected Date createDate;
   @XmlElement(name = "CreateUser") protected String createUser;
   @XmlElement(name = "Description") protected String description;
   @XmlElement(name = "Double", nillable = true) protected Double _double;
   @XmlElement(name = "FinishDate", type = String.class, nillable = true) @XmlJavaTypeAdapter(Adapter1.class) @XmlSchemaType(name = "dateTime") protected Date finishDate;
   @XmlElement(name = "ForeignObjectId") protected Integer foreignObjectId;
   @XmlElement(name = "Indicator") protected String indicator;
   @XmlElement(name = "Integer", nillable = true) protected Integer integer;
   @XmlElement(name = "IsBaseline", nillable = true) protected Boolean isBaseline;
   @XmlElement(name = "IsTemplate") protected Boolean isTemplate;
   @XmlElement(name = "IsUDFTypeCalculated", nillable = true) protected Boolean isUDFTypeCalculated;
   @XmlElement(name = "IsUDFTypeConditional", nillable = true) protected Boolean isUDFTypeConditional;
   @XmlElement(name = "LastUpdateDate", type = String.class, nillable = true) @XmlJavaTypeAdapter(Adapter1.class) @XmlSchemaType(name = "dateTime") protected Date lastUpdateDate;
   @XmlElement(name = "LastUpdateUser") protected String lastUpdateUser;
   @XmlElement(name = "ProjectObjectId", nillable = true) protected Integer projectObjectId;
   @XmlElement(name = "StartDate", type = String.class, nillable = true) @XmlJavaTypeAdapter(Adapter1.class) @XmlSchemaType(name = "dateTime") protected Date startDate;
   @XmlElement(name = "Text") protected String text;
   @XmlElement(name = "UDFCodeObjectId", nillable = true) protected Integer udfCodeObjectId;
   @XmlElement(name = "UDFTypeDataType") protected String udfTypeDataType;
   @XmlElement(name = "UDFTypeObjectId") protected Integer udfTypeObjectId;
   @XmlElement(name = "UDFTypeSubjectArea") protected String udfTypeSubjectArea;
   @XmlElement(name = "UDFTypeTitle") protected String udfTypeTitle;

   /**
    * Gets the value of the codeValue property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getCodeValue()
   {
      return codeValue;
   }

   /**
    * Sets the value of the codeValue property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setCodeValue(String value)
   {
      this.codeValue = value;
   }

   /**
    * Gets the value of the conditionalIndicator property.
    *
    * @return
    *     possible object is
    *     {@link Integer }
    *
    */
   public Integer getConditionalIndicator()
   {
      return conditionalIndicator;
   }

   /**
    * Sets the value of the conditionalIndicator property.
    *
    * @param value
    *     allowed object is
    *     {@link Integer }
    *
    */
   public void setConditionalIndicator(Integer value)
   {
      this.conditionalIndicator = value;
   }

   /**
    * Gets the value of the cost property.
    *
    * @return
    *     possible object is
    *     {@link Double }
    *
    */
   public Double getCost()
   {
      return cost;
   }

   /**
    * Sets the value of the cost property.
    *
    * @param value
    *     allowed object is
    *     {@link Double }
    *
    */
   public void setCost(Double value)
   {
      this.cost = value;
   }

   /**
    * Gets the value of the createDate property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public Date getCreateDate()
   {
      return createDate;
   }

   /**
    * Sets the value of the createDate property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setCreateDate(Date value)
   {
      this.createDate = value;
   }

   /**
    * Gets the value of the createUser property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getCreateUser()
   {
      return createUser;
   }

   /**
    * Sets the value of the createUser property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setCreateUser(String value)
   {
      this.createUser = value;
   }

   /**
    * Gets the value of the description property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getDescription()
   {
      return description;
   }

   /**
    * Sets the value of the description property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setDescription(String value)
   {
      this.description = value;
   }

   /**
    * Gets the value of the double property.
    *
    * @return
    *     possible object is
    *     {@link Double }
    *
    */
   public Double getDouble()
   {
      return _double;
   }

   /**
    * Sets the value of the double property.
    *
    * @param value
    *     allowed object is
    *     {@link Double }
    *
    */
   public void setDouble(Double value)
   {
      this._double = value;
   }

   /**
    * Gets the value of the finishDate property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public Date getFinishDate()
   {
      return finishDate;
   }

   /**
    * Sets the value of the finishDate property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setFinishDate(Date value)
   {
      this.finishDate = value;
   }

   /**
    * Gets the value of the foreignObjectId property.
    *
    * @return
    *     possible object is
    *     {@link Integer }
    *
    */
   public Integer getForeignObjectId()
   {
      return foreignObjectId;
   }

   /**
    * Sets the value of the foreignObjectId property.
    *
    * @param value
    *     allowed object is
    *     {@link Integer }
    *
    */
   public void setForeignObjectId(Integer value)
   {
      this.foreignObjectId = value;
   }

   /**
    * Gets the value of the indicator property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getIndicator()
   {
      return indicator;
   }

   /**
    * Sets the value of the indicator property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setIndicator(String value)
   {
      this.indicator = value;
   }

   /**
    * Gets the value of the integer property.
    *
    * @return
    *     possible object is
    *     {@link Integer }
    *
    */
   public Integer getInteger()
   {
      return integer;
   }

   /**
    * Sets the value of the integer property.
    *
    * @param value
    *     allowed object is
    *     {@link Integer }
    *
    */
   public void setInteger(Integer value)
   {
      this.integer = value;
   }

   /**
    * Gets the value of the isBaseline property.
    *
    * @return
    *     possible object is
    *     {@link Boolean }
    *
    */
   public Boolean isIsBaseline()
   {
      return isBaseline;
   }

   /**
    * Sets the value of the isBaseline property.
    *
    * @param value
    *     allowed object is
    *     {@link Boolean }
    *
    */
   public void setIsBaseline(Boolean value)
   {
      this.isBaseline = value;
   }

   /**
    * Gets the value of the isTemplate property.
    *
    * @return
    *     possible object is
    *     {@link Boolean }
    *
    */
   public Boolean isIsTemplate()
   {
      return isTemplate;
   }

   /**
    * Sets the value of the isTemplate property.
    *
    * @param value
    *     allowed object is
    *     {@link Boolean }
    *
    */
   public void setIsTemplate(Boolean value)
   {
      this.isTemplate = value;
   }

   /**
    * Gets the value of the isUDFTypeCalculated property.
    *
    * @return
    *     possible object is
    *     {@link Boolean }
    *
    */
   public Boolean isIsUDFTypeCalculated()
   {
      return isUDFTypeCalculated;
   }

   /**
    * Sets the value of the isUDFTypeCalculated property.
    *
    * @param value
    *     allowed object is
    *     {@link Boolean }
    *
    */
   public void setIsUDFTypeCalculated(Boolean value)
   {
      this.isUDFTypeCalculated = value;
   }

   /**
    * Gets the value of the isUDFTypeConditional property.
    *
    * @return
    *     possible object is
    *     {@link Boolean }
    *
    */
   public Boolean isIsUDFTypeConditional()
   {
      return isUDFTypeConditional;
   }

   /**
    * Sets the value of the isUDFTypeConditional property.
    *
    * @param value
    *     allowed object is
    *     {@link Boolean }
    *
    */
   public void setIsUDFTypeConditional(Boolean value)
   {
      this.isUDFTypeConditional = value;
   }

   /**
    * Gets the value of the lastUpdateDate property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public Date getLastUpdateDate()
   {
      return lastUpdateDate;
   }

   /**
    * Sets the value of the lastUpdateDate property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setLastUpdateDate(Date value)
   {
      this.lastUpdateDate = value;
   }

   /**
    * Gets the value of the lastUpdateUser property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getLastUpdateUser()
   {
      return lastUpdateUser;
   }

   /**
    * Sets the value of the lastUpdateUser property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setLastUpdateUser(String value)
   {
      this.lastUpdateUser = value;
   }

   /**
    * Gets the value of the projectObjectId property.
    *
    * @return
    *     possible object is
    *     {@link Integer }
    *
    */
   public Integer getProjectObjectId()
   {
      return projectObjectId;
   }

   /**
    * Sets the value of the projectObjectId property.
    *
    * @param value
    *     allowed object is
    *     {@link Integer }
    *
    */
   public void setProjectObjectId(Integer value)
   {
      this.projectObjectId = value;
   }

   /**
    * Gets the value of the startDate property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public Date getStartDate()
   {
      return startDate;
   }

   /**
    * Sets the value of the startDate property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setStartDate(Date value)
   {
      this.startDate = value;
   }

   /**
    * Gets the value of the text property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getText()
   {
      return text;
   }

   /**
    * Sets the value of the text property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setText(String value)
   {
      this.text = value;
   }

   /**
    * Gets the value of the udfCodeObjectId property.
    *
    * @return
    *     possible object is
    *     {@link Integer }
    *
    */
   public Integer getUDFCodeObjectId()
   {
      return udfCodeObjectId;
   }

   /**
    * Sets the value of the udfCodeObjectId property.
    *
    * @param value
    *     allowed object is
    *     {@link Integer }
    *
    */
   public void setUDFCodeObjectId(Integer value)
   {
      this.udfCodeObjectId = value;
   }

   /**
    * Gets the value of the udfTypeDataType property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getUDFTypeDataType()
   {
      return udfTypeDataType;
   }

   /**
    * Sets the value of the udfTypeDataType property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setUDFTypeDataType(String value)
   {
      this.udfTypeDataType = value;
   }

   /**
    * Gets the value of the udfTypeObjectId property.
    *
    * @return
    *     possible object is
    *     {@link Integer }
    *
    */
   public Integer getUDFTypeObjectId()
   {
      return udfTypeObjectId;
   }

   /**
    * Sets the value of the udfTypeObjectId property.
    *
    * @param value
    *     allowed object is
    *     {@link Integer }
    *
    */
   public void setUDFTypeObjectId(Integer value)
   {
      this.udfTypeObjectId = value;
   }

   /**
    * Gets the value of the udfTypeSubjectArea property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getUDFTypeSubjectArea()
   {
      return udfTypeSubjectArea;
   }

   /**
    * Sets the value of the udfTypeSubjectArea property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setUDFTypeSubjectArea(String value)
   {
      this.udfTypeSubjectArea = value;
   }

   /**
    * Gets the value of the udfTypeTitle property.
    *
    * @return
    *     possible object is
    *     {@link String }
    *
    */
   public String getUDFTypeTitle()
   {
      return udfTypeTitle;
   }

   /**
    * Sets the value of the udfTypeTitle property.
    *
    * @param value
    *     allowed object is
    *     {@link String }
    *
    */
   public void setUDFTypeTitle(String value)
   {
      this.udfTypeTitle = value;
   }

}
