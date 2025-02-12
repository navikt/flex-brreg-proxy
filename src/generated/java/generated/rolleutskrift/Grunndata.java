
package generated.rolleutskrift;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="responseHeader"&amp;gt;
 *           &amp;lt;complexType&amp;gt;
 *             &amp;lt;complexContent&amp;gt;
 *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                 &amp;lt;sequence&amp;gt;
 *                   &amp;lt;choice&amp;gt;
 *                     &amp;lt;element name="orgnr" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *                     &amp;lt;element name="fodselsnr"&amp;gt;
 *                       &amp;lt;simpleType&amp;gt;
 *                         &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *                           &amp;lt;length value="11"/&amp;gt;
 *                         &amp;lt;/restriction&amp;gt;
 *                       &amp;lt;/simpleType&amp;gt;
 *                     &amp;lt;/element&amp;gt;
 *                     &amp;lt;element name="requestID" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *                   &amp;lt;/choice&amp;gt;
 *                   &amp;lt;element name="hovedStatus" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *                   &amp;lt;element name="underStatus"&amp;gt;
 *                     &amp;lt;complexType&amp;gt;
 *                       &amp;lt;complexContent&amp;gt;
 *                         &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                           &amp;lt;sequence&amp;gt;
 *                             &amp;lt;element name="underStatusMelding" maxOccurs="unbounded"&amp;gt;
 *                               &amp;lt;complexType&amp;gt;
 *                                 &amp;lt;simpleContent&amp;gt;
 *                                   &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
 *                                     &amp;lt;attribute name="kode" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&amp;gt;
 *                                   &amp;lt;/extension&amp;gt;
 *                                 &amp;lt;/simpleContent&amp;gt;
 *                               &amp;lt;/complexType&amp;gt;
 *                             &amp;lt;/element&amp;gt;
 *                           &amp;lt;/sequence&amp;gt;
 *                         &amp;lt;/restriction&amp;gt;
 *                       &amp;lt;/complexContent&amp;gt;
 *                     &amp;lt;/complexType&amp;gt;
 *                   &amp;lt;/element&amp;gt;
 *                 &amp;lt;/sequence&amp;gt;
 *                 &amp;lt;attribute name="prossessDato" use="required" type="{http://www.w3.org/2001/XMLSchema}date" /&amp;gt;
 *                 &amp;lt;attribute name="tjeneste" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *               &amp;lt;/restriction&amp;gt;
 *             &amp;lt;/complexContent&amp;gt;
 *           &amp;lt;/complexType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="melding" minOccurs="0"&amp;gt;
 *           &amp;lt;complexType&amp;gt;
 *             &amp;lt;complexContent&amp;gt;
 *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                 &amp;lt;sequence&amp;gt;
 *                   &amp;lt;element name="rolleInnehaver"&amp;gt;
 *                     &amp;lt;complexType&amp;gt;
 *                       &amp;lt;complexContent&amp;gt;
 *                         &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                           &amp;lt;sequence&amp;gt;
 *                             &amp;lt;choice&amp;gt;
 *                               &amp;lt;element name="orgnr"&amp;gt;
 *                                 &amp;lt;complexType&amp;gt;
 *                                   &amp;lt;simpleContent&amp;gt;
 *                                     &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;int"&amp;gt;
 *                                       &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *                                     &amp;lt;/extension&amp;gt;
 *                                   &amp;lt;/simpleContent&amp;gt;
 *                                 &amp;lt;/complexType&amp;gt;
 *                               &amp;lt;/element&amp;gt;
 *                               &amp;lt;element name="fodselsnr"&amp;gt;
 *                                 &amp;lt;complexType&amp;gt;
 *                                   &amp;lt;simpleContent&amp;gt;
 *                                     &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
 *                                       &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *                                     &amp;lt;/extension&amp;gt;
 *                                   &amp;lt;/simpleContent&amp;gt;
 *                                 &amp;lt;/complexType&amp;gt;
 *                               &amp;lt;/element&amp;gt;
 *                               &amp;lt;element name="fodselsdato"&amp;gt;
 *                                 &amp;lt;complexType&amp;gt;
 *                                   &amp;lt;simpleContent&amp;gt;
 *                                     &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;date"&amp;gt;
 *                                       &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *                                     &amp;lt;/extension&amp;gt;
 *                                   &amp;lt;/simpleContent&amp;gt;
 *                                 &amp;lt;/complexType&amp;gt;
 *                               &amp;lt;/element&amp;gt;
 *                             &amp;lt;/choice&amp;gt;
 *                             &amp;lt;element name="navn" type="{}navnType"/&amp;gt;
 *                             &amp;lt;element name="adresse" type="{}adresseType1"/&amp;gt;
 *                           &amp;lt;/sequence&amp;gt;
 *                         &amp;lt;/restriction&amp;gt;
 *                       &amp;lt;/complexContent&amp;gt;
 *                     &amp;lt;/complexType&amp;gt;
 *                   &amp;lt;/element&amp;gt;
 *                   &amp;lt;element name="roller" minOccurs="0"&amp;gt;
 *                     &amp;lt;complexType&amp;gt;
 *                       &amp;lt;complexContent&amp;gt;
 *                         &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                           &amp;lt;sequence&amp;gt;
 *                             &amp;lt;element name="enhet" maxOccurs="unbounded"&amp;gt;
 *                               &amp;lt;complexType&amp;gt;
 *                                 &amp;lt;complexContent&amp;gt;
 *                                   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                                     &amp;lt;sequence&amp;gt;
 *                                       &amp;lt;element name="rolleBeskrivelse"&amp;gt;
 *                                         &amp;lt;complexType&amp;gt;
 *                                           &amp;lt;simpleContent&amp;gt;
 *                                             &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
 *                                               &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *                                             &amp;lt;/extension&amp;gt;
 *                                           &amp;lt;/simpleContent&amp;gt;
 *                                         &amp;lt;/complexType&amp;gt;
 *                                       &amp;lt;/element&amp;gt;
 *                                       &amp;lt;element name="orgnr"&amp;gt;
 *                                         &amp;lt;complexType&amp;gt;
 *                                           &amp;lt;simpleContent&amp;gt;
 *                                             &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;int"&amp;gt;
 *                                               &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *                                             &amp;lt;/extension&amp;gt;
 *                                           &amp;lt;/simpleContent&amp;gt;
 *                                         &amp;lt;/complexType&amp;gt;
 *                                       &amp;lt;/element&amp;gt;
 *                                       &amp;lt;element name="navn" type="{}navnType"/&amp;gt;
 *                                       &amp;lt;element name="adresse"&amp;gt;
 *                                         &amp;lt;complexType&amp;gt;
 *                                           &amp;lt;complexContent&amp;gt;
 *                                             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                                               &amp;lt;sequence&amp;gt;
 *                                                 &amp;lt;element name="forretningsAdresse" type="{}adresseType2" minOccurs="0"/&amp;gt;
 *                                                 &amp;lt;element name="postAdresse" type="{}adresseType2" minOccurs="0"/&amp;gt;
 *                                               &amp;lt;/sequence&amp;gt;
 *                                             &amp;lt;/restriction&amp;gt;
 *                                           &amp;lt;/complexContent&amp;gt;
 *                                         &amp;lt;/complexType&amp;gt;
 *                                       &amp;lt;/element&amp;gt;
 *                                     &amp;lt;/sequence&amp;gt;
 *                                     &amp;lt;attribute name="nr" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&amp;gt;
 *                                     &amp;lt;attribute name="registreringsDato" use="required" type="{http://www.w3.org/2001/XMLSchema}date" /&amp;gt;
 *                                   &amp;lt;/restriction&amp;gt;
 *                                 &amp;lt;/complexContent&amp;gt;
 *                               &amp;lt;/complexType&amp;gt;
 *                             &amp;lt;/element&amp;gt;
 *                           &amp;lt;/sequence&amp;gt;
 *                           &amp;lt;attribute name="ledetekst" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *                         &amp;lt;/restriction&amp;gt;
 *                       &amp;lt;/complexContent&amp;gt;
 *                     &amp;lt;/complexType&amp;gt;
 *                   &amp;lt;/element&amp;gt;
 *                 &amp;lt;/sequence&amp;gt;
 *                 &amp;lt;attribute name="tjeneste" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *               &amp;lt;/restriction&amp;gt;
 *             &amp;lt;/complexContent&amp;gt;
 *           &amp;lt;/complexType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "responseHeader",
    "melding"
})
@XmlRootElement(name = "grunndata")
public class Grunndata {

    @XmlElement(required = true)
    protected Grunndata.ResponseHeader responseHeader;
    protected Grunndata.Melding melding;

    /**
     * Gets the value of the responseHeader property.
     * 
     * @return
     *     possible object is
     *     {@link Grunndata.ResponseHeader }
     *     
     */
    public Grunndata.ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    /**
     * Sets the value of the responseHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link Grunndata.ResponseHeader }
     *     
     */
    public void setResponseHeader(Grunndata.ResponseHeader value) {
        this.responseHeader = value;
    }

    /**
     * Gets the value of the melding property.
     * 
     * @return
     *     possible object is
     *     {@link Grunndata.Melding }
     *     
     */
    public Grunndata.Melding getMelding() {
        return melding;
    }

    /**
     * Sets the value of the melding property.
     * 
     * @param value
     *     allowed object is
     *     {@link Grunndata.Melding }
     *     
     */
    public void setMelding(Grunndata.Melding value) {
        this.melding = value;
    }


    /**
     * &lt;p&gt;Java class for anonymous complex type.
     * 
     * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
     * 
     * &lt;pre&gt;
     * &amp;lt;complexType&amp;gt;
     *   &amp;lt;complexContent&amp;gt;
     *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
     *       &amp;lt;sequence&amp;gt;
     *         &amp;lt;element name="rolleInnehaver"&amp;gt;
     *           &amp;lt;complexType&amp;gt;
     *             &amp;lt;complexContent&amp;gt;
     *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
     *                 &amp;lt;sequence&amp;gt;
     *                   &amp;lt;choice&amp;gt;
     *                     &amp;lt;element name="orgnr"&amp;gt;
     *                       &amp;lt;complexType&amp;gt;
     *                         &amp;lt;simpleContent&amp;gt;
     *                           &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;int"&amp;gt;
     *                             &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
     *                           &amp;lt;/extension&amp;gt;
     *                         &amp;lt;/simpleContent&amp;gt;
     *                       &amp;lt;/complexType&amp;gt;
     *                     &amp;lt;/element&amp;gt;
     *                     &amp;lt;element name="fodselsnr"&amp;gt;
     *                       &amp;lt;complexType&amp;gt;
     *                         &amp;lt;simpleContent&amp;gt;
     *                           &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
     *                             &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
     *                           &amp;lt;/extension&amp;gt;
     *                         &amp;lt;/simpleContent&amp;gt;
     *                       &amp;lt;/complexType&amp;gt;
     *                     &amp;lt;/element&amp;gt;
     *                     &amp;lt;element name="fodselsdato"&amp;gt;
     *                       &amp;lt;complexType&amp;gt;
     *                         &amp;lt;simpleContent&amp;gt;
     *                           &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;date"&amp;gt;
     *                             &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
     *                           &amp;lt;/extension&amp;gt;
     *                         &amp;lt;/simpleContent&amp;gt;
     *                       &amp;lt;/complexType&amp;gt;
     *                     &amp;lt;/element&amp;gt;
     *                   &amp;lt;/choice&amp;gt;
     *                   &amp;lt;element name="navn" type="{}navnType"/&amp;gt;
     *                   &amp;lt;element name="adresse" type="{}adresseType1"/&amp;gt;
     *                 &amp;lt;/sequence&amp;gt;
     *               &amp;lt;/restriction&amp;gt;
     *             &amp;lt;/complexContent&amp;gt;
     *           &amp;lt;/complexType&amp;gt;
     *         &amp;lt;/element&amp;gt;
     *         &amp;lt;element name="roller" minOccurs="0"&amp;gt;
     *           &amp;lt;complexType&amp;gt;
     *             &amp;lt;complexContent&amp;gt;
     *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
     *                 &amp;lt;sequence&amp;gt;
     *                   &amp;lt;element name="enhet" maxOccurs="unbounded"&amp;gt;
     *                     &amp;lt;complexType&amp;gt;
     *                       &amp;lt;complexContent&amp;gt;
     *                         &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
     *                           &amp;lt;sequence&amp;gt;
     *                             &amp;lt;element name="rolleBeskrivelse"&amp;gt;
     *                               &amp;lt;complexType&amp;gt;
     *                                 &amp;lt;simpleContent&amp;gt;
     *                                   &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
     *                                     &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
     *                                   &amp;lt;/extension&amp;gt;
     *                                 &amp;lt;/simpleContent&amp;gt;
     *                               &amp;lt;/complexType&amp;gt;
     *                             &amp;lt;/element&amp;gt;
     *                             &amp;lt;element name="orgnr"&amp;gt;
     *                               &amp;lt;complexType&amp;gt;
     *                                 &amp;lt;simpleContent&amp;gt;
     *                                   &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;int"&amp;gt;
     *                                     &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
     *                                   &amp;lt;/extension&amp;gt;
     *                                 &amp;lt;/simpleContent&amp;gt;
     *                               &amp;lt;/complexType&amp;gt;
     *                             &amp;lt;/element&amp;gt;
     *                             &amp;lt;element name="navn" type="{}navnType"/&amp;gt;
     *                             &amp;lt;element name="adresse"&amp;gt;
     *                               &amp;lt;complexType&amp;gt;
     *                                 &amp;lt;complexContent&amp;gt;
     *                                   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
     *                                     &amp;lt;sequence&amp;gt;
     *                                       &amp;lt;element name="forretningsAdresse" type="{}adresseType2" minOccurs="0"/&amp;gt;
     *                                       &amp;lt;element name="postAdresse" type="{}adresseType2" minOccurs="0"/&amp;gt;
     *                                     &amp;lt;/sequence&amp;gt;
     *                                   &amp;lt;/restriction&amp;gt;
     *                                 &amp;lt;/complexContent&amp;gt;
     *                               &amp;lt;/complexType&amp;gt;
     *                             &amp;lt;/element&amp;gt;
     *                           &amp;lt;/sequence&amp;gt;
     *                           &amp;lt;attribute name="nr" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&amp;gt;
     *                           &amp;lt;attribute name="registreringsDato" use="required" type="{http://www.w3.org/2001/XMLSchema}date" /&amp;gt;
     *                         &amp;lt;/restriction&amp;gt;
     *                       &amp;lt;/complexContent&amp;gt;
     *                     &amp;lt;/complexType&amp;gt;
     *                   &amp;lt;/element&amp;gt;
     *                 &amp;lt;/sequence&amp;gt;
     *                 &amp;lt;attribute name="ledetekst" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
     *               &amp;lt;/restriction&amp;gt;
     *             &amp;lt;/complexContent&amp;gt;
     *           &amp;lt;/complexType&amp;gt;
     *         &amp;lt;/element&amp;gt;
     *       &amp;lt;/sequence&amp;gt;
     *       &amp;lt;attribute name="tjeneste" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
     *     &amp;lt;/restriction&amp;gt;
     *   &amp;lt;/complexContent&amp;gt;
     * &amp;lt;/complexType&amp;gt;
     * &lt;/pre&gt;
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "rolleInnehaver",
        "roller"
    })
    public static class Melding {

        @XmlElement(required = true)
        protected Grunndata.Melding.RolleInnehaver rolleInnehaver;
        protected Grunndata.Melding.Roller roller;
        @XmlAttribute(name = "tjeneste", required = true)
        protected String tjeneste;

        /**
         * Gets the value of the rolleInnehaver property.
         * 
         * @return
         *     possible object is
         *     {@link Grunndata.Melding.RolleInnehaver }
         *     
         */
        public Grunndata.Melding.RolleInnehaver getRolleInnehaver() {
            return rolleInnehaver;
        }

        /**
         * Sets the value of the rolleInnehaver property.
         * 
         * @param value
         *     allowed object is
         *     {@link Grunndata.Melding.RolleInnehaver }
         *     
         */
        public void setRolleInnehaver(Grunndata.Melding.RolleInnehaver value) {
            this.rolleInnehaver = value;
        }

        /**
         * Gets the value of the roller property.
         * 
         * @return
         *     possible object is
         *     {@link Grunndata.Melding.Roller }
         *     
         */
        public Grunndata.Melding.Roller getRoller() {
            return roller;
        }

        /**
         * Sets the value of the roller property.
         * 
         * @param value
         *     allowed object is
         *     {@link Grunndata.Melding.Roller }
         *     
         */
        public void setRoller(Grunndata.Melding.Roller value) {
            this.roller = value;
        }

        /**
         * Gets the value of the tjeneste property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTjeneste() {
            return tjeneste;
        }

        /**
         * Sets the value of the tjeneste property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTjeneste(String value) {
            this.tjeneste = value;
        }


        /**
         * &lt;p&gt;Java class for anonymous complex type.
         * 
         * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
         * 
         * &lt;pre&gt;
         * &amp;lt;complexType&amp;gt;
         *   &amp;lt;complexContent&amp;gt;
         *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
         *       &amp;lt;sequence&amp;gt;
         *         &amp;lt;choice&amp;gt;
         *           &amp;lt;element name="orgnr"&amp;gt;
         *             &amp;lt;complexType&amp;gt;
         *               &amp;lt;simpleContent&amp;gt;
         *                 &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;int"&amp;gt;
         *                   &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
         *                 &amp;lt;/extension&amp;gt;
         *               &amp;lt;/simpleContent&amp;gt;
         *             &amp;lt;/complexType&amp;gt;
         *           &amp;lt;/element&amp;gt;
         *           &amp;lt;element name="fodselsnr"&amp;gt;
         *             &amp;lt;complexType&amp;gt;
         *               &amp;lt;simpleContent&amp;gt;
         *                 &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
         *                   &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
         *                 &amp;lt;/extension&amp;gt;
         *               &amp;lt;/simpleContent&amp;gt;
         *             &amp;lt;/complexType&amp;gt;
         *           &amp;lt;/element&amp;gt;
         *           &amp;lt;element name="fodselsdato"&amp;gt;
         *             &amp;lt;complexType&amp;gt;
         *               &amp;lt;simpleContent&amp;gt;
         *                 &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;date"&amp;gt;
         *                   &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
         *                 &amp;lt;/extension&amp;gt;
         *               &amp;lt;/simpleContent&amp;gt;
         *             &amp;lt;/complexType&amp;gt;
         *           &amp;lt;/element&amp;gt;
         *         &amp;lt;/choice&amp;gt;
         *         &amp;lt;element name="navn" type="{}navnType"/&amp;gt;
         *         &amp;lt;element name="adresse" type="{}adresseType1"/&amp;gt;
         *       &amp;lt;/sequence&amp;gt;
         *     &amp;lt;/restriction&amp;gt;
         *   &amp;lt;/complexContent&amp;gt;
         * &amp;lt;/complexType&amp;gt;
         * &lt;/pre&gt;
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "orgnr",
            "fodselsnr",
            "fodselsdato",
            "navn",
            "adresse"
        })
        public static class RolleInnehaver {

            protected Grunndata.Melding.RolleInnehaver.Orgnr orgnr;
            protected Grunndata.Melding.RolleInnehaver.Fodselsnr fodselsnr;
            protected Grunndata.Melding.RolleInnehaver.Fodselsdato fodselsdato;
            @XmlElement(required = true)
            protected NavnType navn;
            @XmlElement(required = true)
            protected AdresseType1 adresse;

            /**
             * Gets the value of the orgnr property.
             * 
             * @return
             *     possible object is
             *     {@link Grunndata.Melding.RolleInnehaver.Orgnr }
             *     
             */
            public Grunndata.Melding.RolleInnehaver.Orgnr getOrgnr() {
                return orgnr;
            }

            /**
             * Sets the value of the orgnr property.
             * 
             * @param value
             *     allowed object is
             *     {@link Grunndata.Melding.RolleInnehaver.Orgnr }
             *     
             */
            public void setOrgnr(Grunndata.Melding.RolleInnehaver.Orgnr value) {
                this.orgnr = value;
            }

            /**
             * Gets the value of the fodselsnr property.
             * 
             * @return
             *     possible object is
             *     {@link Grunndata.Melding.RolleInnehaver.Fodselsnr }
             *     
             */
            public Grunndata.Melding.RolleInnehaver.Fodselsnr getFodselsnr() {
                return fodselsnr;
            }

            /**
             * Sets the value of the fodselsnr property.
             * 
             * @param value
             *     allowed object is
             *     {@link Grunndata.Melding.RolleInnehaver.Fodselsnr }
             *     
             */
            public void setFodselsnr(Grunndata.Melding.RolleInnehaver.Fodselsnr value) {
                this.fodselsnr = value;
            }

            /**
             * Gets the value of the fodselsdato property.
             * 
             * @return
             *     possible object is
             *     {@link Grunndata.Melding.RolleInnehaver.Fodselsdato }
             *     
             */
            public Grunndata.Melding.RolleInnehaver.Fodselsdato getFodselsdato() {
                return fodselsdato;
            }

            /**
             * Sets the value of the fodselsdato property.
             * 
             * @param value
             *     allowed object is
             *     {@link Grunndata.Melding.RolleInnehaver.Fodselsdato }
             *     
             */
            public void setFodselsdato(Grunndata.Melding.RolleInnehaver.Fodselsdato value) {
                this.fodselsdato = value;
            }

            /**
             * Gets the value of the navn property.
             * 
             * @return
             *     possible object is
             *     {@link NavnType }
             *     
             */
            public NavnType getNavn() {
                return navn;
            }

            /**
             * Sets the value of the navn property.
             * 
             * @param value
             *     allowed object is
             *     {@link NavnType }
             *     
             */
            public void setNavn(NavnType value) {
                this.navn = value;
            }

            /**
             * Gets the value of the adresse property.
             * 
             * @return
             *     possible object is
             *     {@link AdresseType1 }
             *     
             */
            public AdresseType1 getAdresse() {
                return adresse;
            }

            /**
             * Sets the value of the adresse property.
             * 
             * @param value
             *     allowed object is
             *     {@link AdresseType1 }
             *     
             */
            public void setAdresse(AdresseType1 value) {
                this.adresse = value;
            }


            /**
             * &lt;p&gt;Java class for anonymous complex type.
             * 
             * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
             * 
             * &lt;pre&gt;
             * &amp;lt;complexType&amp;gt;
             *   &amp;lt;simpleContent&amp;gt;
             *     &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;date"&amp;gt;
             *       &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
             *     &amp;lt;/extension&amp;gt;
             *   &amp;lt;/simpleContent&amp;gt;
             * &amp;lt;/complexType&amp;gt;
             * &lt;/pre&gt;
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Fodselsdato {

                @XmlValue
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar value;
                @XmlAttribute(name = "ledetekst")
                protected String ledetekst;

                /**
                 * Gets the value of the value property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setValue(XMLGregorianCalendar value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the ledetekst property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLedetekst() {
                    return ledetekst;
                }

                /**
                 * Sets the value of the ledetekst property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLedetekst(String value) {
                    this.ledetekst = value;
                }

            }


            /**
             * &lt;p&gt;Java class for anonymous complex type.
             * 
             * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
             * 
             * &lt;pre&gt;
             * &amp;lt;complexType&amp;gt;
             *   &amp;lt;simpleContent&amp;gt;
             *     &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
             *       &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
             *     &amp;lt;/extension&amp;gt;
             *   &amp;lt;/simpleContent&amp;gt;
             * &amp;lt;/complexType&amp;gt;
             * &lt;/pre&gt;
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Fodselsnr {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "ledetekst")
                protected String ledetekst;

                /**
                 * Gets the value of the value property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the ledetekst property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLedetekst() {
                    return ledetekst;
                }

                /**
                 * Sets the value of the ledetekst property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLedetekst(String value) {
                    this.ledetekst = value;
                }

            }


            /**
             * &lt;p&gt;Java class for anonymous complex type.
             * 
             * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
             * 
             * &lt;pre&gt;
             * &amp;lt;complexType&amp;gt;
             *   &amp;lt;simpleContent&amp;gt;
             *     &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;int"&amp;gt;
             *       &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
             *     &amp;lt;/extension&amp;gt;
             *   &amp;lt;/simpleContent&amp;gt;
             * &amp;lt;/complexType&amp;gt;
             * &lt;/pre&gt;
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Orgnr {

                @XmlValue
                protected int value;
                @XmlAttribute(name = "ledetekst")
                protected String ledetekst;

                /**
                 * Gets the value of the value property.
                 * 
                 */
                public int getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 */
                public void setValue(int value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the ledetekst property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLedetekst() {
                    return ledetekst;
                }

                /**
                 * Sets the value of the ledetekst property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLedetekst(String value) {
                    this.ledetekst = value;
                }

            }

        }


        /**
         * &lt;p&gt;Java class for anonymous complex type.
         * 
         * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
         * 
         * &lt;pre&gt;
         * &amp;lt;complexType&amp;gt;
         *   &amp;lt;complexContent&amp;gt;
         *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
         *       &amp;lt;sequence&amp;gt;
         *         &amp;lt;element name="enhet" maxOccurs="unbounded"&amp;gt;
         *           &amp;lt;complexType&amp;gt;
         *             &amp;lt;complexContent&amp;gt;
         *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
         *                 &amp;lt;sequence&amp;gt;
         *                   &amp;lt;element name="rolleBeskrivelse"&amp;gt;
         *                     &amp;lt;complexType&amp;gt;
         *                       &amp;lt;simpleContent&amp;gt;
         *                         &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
         *                           &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
         *                         &amp;lt;/extension&amp;gt;
         *                       &amp;lt;/simpleContent&amp;gt;
         *                     &amp;lt;/complexType&amp;gt;
         *                   &amp;lt;/element&amp;gt;
         *                   &amp;lt;element name="orgnr"&amp;gt;
         *                     &amp;lt;complexType&amp;gt;
         *                       &amp;lt;simpleContent&amp;gt;
         *                         &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;int"&amp;gt;
         *                           &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
         *                         &amp;lt;/extension&amp;gt;
         *                       &amp;lt;/simpleContent&amp;gt;
         *                     &amp;lt;/complexType&amp;gt;
         *                   &amp;lt;/element&amp;gt;
         *                   &amp;lt;element name="navn" type="{}navnType"/&amp;gt;
         *                   &amp;lt;element name="adresse"&amp;gt;
         *                     &amp;lt;complexType&amp;gt;
         *                       &amp;lt;complexContent&amp;gt;
         *                         &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
         *                           &amp;lt;sequence&amp;gt;
         *                             &amp;lt;element name="forretningsAdresse" type="{}adresseType2" minOccurs="0"/&amp;gt;
         *                             &amp;lt;element name="postAdresse" type="{}adresseType2" minOccurs="0"/&amp;gt;
         *                           &amp;lt;/sequence&amp;gt;
         *                         &amp;lt;/restriction&amp;gt;
         *                       &amp;lt;/complexContent&amp;gt;
         *                     &amp;lt;/complexType&amp;gt;
         *                   &amp;lt;/element&amp;gt;
         *                 &amp;lt;/sequence&amp;gt;
         *                 &amp;lt;attribute name="nr" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&amp;gt;
         *                 &amp;lt;attribute name="registreringsDato" use="required" type="{http://www.w3.org/2001/XMLSchema}date" /&amp;gt;
         *               &amp;lt;/restriction&amp;gt;
         *             &amp;lt;/complexContent&amp;gt;
         *           &amp;lt;/complexType&amp;gt;
         *         &amp;lt;/element&amp;gt;
         *       &amp;lt;/sequence&amp;gt;
         *       &amp;lt;attribute name="ledetekst" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
         *     &amp;lt;/restriction&amp;gt;
         *   &amp;lt;/complexContent&amp;gt;
         * &amp;lt;/complexType&amp;gt;
         * &lt;/pre&gt;
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "enhet"
        })
        public static class Roller {

            @XmlElement(required = true)
            protected List<Grunndata.Melding.Roller.Enhet> enhet;
            @XmlAttribute(name = "ledetekst", required = true)
            protected String ledetekst;

            /**
             * Gets the value of the enhet property.
             * 
             * &lt;p&gt;
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the enhet property.
             * 
             * &lt;p&gt;
             * For example, to add a new item, do as follows:
             * &lt;pre&gt;
             *    getEnhet().add(newItem);
             * &lt;/pre&gt;
             * 
             * 
             * &lt;p&gt;
             * Objects of the following type(s) are allowed in the list
             * {@link Grunndata.Melding.Roller.Enhet }
             * 
             * 
             */
            public List<Grunndata.Melding.Roller.Enhet> getEnhet() {
                if (enhet == null) {
                    enhet = new ArrayList<Grunndata.Melding.Roller.Enhet>();
                }
                return this.enhet;
            }

            /**
             * Gets the value of the ledetekst property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLedetekst() {
                return ledetekst;
            }

            /**
             * Sets the value of the ledetekst property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLedetekst(String value) {
                this.ledetekst = value;
            }


            /**
             * &lt;p&gt;Java class for anonymous complex type.
             * 
             * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
             * 
             * &lt;pre&gt;
             * &amp;lt;complexType&amp;gt;
             *   &amp;lt;complexContent&amp;gt;
             *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
             *       &amp;lt;sequence&amp;gt;
             *         &amp;lt;element name="rolleBeskrivelse"&amp;gt;
             *           &amp;lt;complexType&amp;gt;
             *             &amp;lt;simpleContent&amp;gt;
             *               &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
             *                 &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
             *               &amp;lt;/extension&amp;gt;
             *             &amp;lt;/simpleContent&amp;gt;
             *           &amp;lt;/complexType&amp;gt;
             *         &amp;lt;/element&amp;gt;
             *         &amp;lt;element name="orgnr"&amp;gt;
             *           &amp;lt;complexType&amp;gt;
             *             &amp;lt;simpleContent&amp;gt;
             *               &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;int"&amp;gt;
             *                 &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
             *               &amp;lt;/extension&amp;gt;
             *             &amp;lt;/simpleContent&amp;gt;
             *           &amp;lt;/complexType&amp;gt;
             *         &amp;lt;/element&amp;gt;
             *         &amp;lt;element name="navn" type="{}navnType"/&amp;gt;
             *         &amp;lt;element name="adresse"&amp;gt;
             *           &amp;lt;complexType&amp;gt;
             *             &amp;lt;complexContent&amp;gt;
             *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
             *                 &amp;lt;sequence&amp;gt;
             *                   &amp;lt;element name="forretningsAdresse" type="{}adresseType2" minOccurs="0"/&amp;gt;
             *                   &amp;lt;element name="postAdresse" type="{}adresseType2" minOccurs="0"/&amp;gt;
             *                 &amp;lt;/sequence&amp;gt;
             *               &amp;lt;/restriction&amp;gt;
             *             &amp;lt;/complexContent&amp;gt;
             *           &amp;lt;/complexType&amp;gt;
             *         &amp;lt;/element&amp;gt;
             *       &amp;lt;/sequence&amp;gt;
             *       &amp;lt;attribute name="nr" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&amp;gt;
             *       &amp;lt;attribute name="registreringsDato" use="required" type="{http://www.w3.org/2001/XMLSchema}date" /&amp;gt;
             *     &amp;lt;/restriction&amp;gt;
             *   &amp;lt;/complexContent&amp;gt;
             * &amp;lt;/complexType&amp;gt;
             * &lt;/pre&gt;
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "rolleBeskrivelse",
                "orgnr",
                "navn",
                "adresse"
            })
            public static class Enhet {

                @XmlElement(required = true)
                protected Grunndata.Melding.Roller.Enhet.RolleBeskrivelse rolleBeskrivelse;
                @XmlElement(required = true)
                protected Grunndata.Melding.Roller.Enhet.Orgnr orgnr;
                @XmlElement(required = true)
                protected NavnType navn;
                @XmlElement(required = true)
                protected Grunndata.Melding.Roller.Enhet.Adresse adresse;
                @XmlAttribute(name = "nr", required = true)
                protected int nr;
                @XmlAttribute(name = "registreringsDato", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar registreringsDato;

                /**
                 * Gets the value of the rolleBeskrivelse property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Grunndata.Melding.Roller.Enhet.RolleBeskrivelse }
                 *     
                 */
                public Grunndata.Melding.Roller.Enhet.RolleBeskrivelse getRolleBeskrivelse() {
                    return rolleBeskrivelse;
                }

                /**
                 * Sets the value of the rolleBeskrivelse property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Grunndata.Melding.Roller.Enhet.RolleBeskrivelse }
                 *     
                 */
                public void setRolleBeskrivelse(Grunndata.Melding.Roller.Enhet.RolleBeskrivelse value) {
                    this.rolleBeskrivelse = value;
                }

                /**
                 * Gets the value of the orgnr property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Grunndata.Melding.Roller.Enhet.Orgnr }
                 *     
                 */
                public Grunndata.Melding.Roller.Enhet.Orgnr getOrgnr() {
                    return orgnr;
                }

                /**
                 * Sets the value of the orgnr property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Grunndata.Melding.Roller.Enhet.Orgnr }
                 *     
                 */
                public void setOrgnr(Grunndata.Melding.Roller.Enhet.Orgnr value) {
                    this.orgnr = value;
                }

                /**
                 * Gets the value of the navn property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link NavnType }
                 *     
                 */
                public NavnType getNavn() {
                    return navn;
                }

                /**
                 * Sets the value of the navn property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link NavnType }
                 *     
                 */
                public void setNavn(NavnType value) {
                    this.navn = value;
                }

                /**
                 * Gets the value of the adresse property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Grunndata.Melding.Roller.Enhet.Adresse }
                 *     
                 */
                public Grunndata.Melding.Roller.Enhet.Adresse getAdresse() {
                    return adresse;
                }

                /**
                 * Sets the value of the adresse property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Grunndata.Melding.Roller.Enhet.Adresse }
                 *     
                 */
                public void setAdresse(Grunndata.Melding.Roller.Enhet.Adresse value) {
                    this.adresse = value;
                }

                /**
                 * Gets the value of the nr property.
                 * 
                 */
                public int getNr() {
                    return nr;
                }

                /**
                 * Sets the value of the nr property.
                 * 
                 */
                public void setNr(int value) {
                    this.nr = value;
                }

                /**
                 * Gets the value of the registreringsDato property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getRegistreringsDato() {
                    return registreringsDato;
                }

                /**
                 * Sets the value of the registreringsDato property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setRegistreringsDato(XMLGregorianCalendar value) {
                    this.registreringsDato = value;
                }


                /**
                 * &lt;p&gt;Java class for anonymous complex type.
                 * 
                 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
                 * 
                 * &lt;pre&gt;
                 * &amp;lt;complexType&amp;gt;
                 *   &amp;lt;complexContent&amp;gt;
                 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
                 *       &amp;lt;sequence&amp;gt;
                 *         &amp;lt;element name="forretningsAdresse" type="{}adresseType2" minOccurs="0"/&amp;gt;
                 *         &amp;lt;element name="postAdresse" type="{}adresseType2" minOccurs="0"/&amp;gt;
                 *       &amp;lt;/sequence&amp;gt;
                 *     &amp;lt;/restriction&amp;gt;
                 *   &amp;lt;/complexContent&amp;gt;
                 * &amp;lt;/complexType&amp;gt;
                 * &lt;/pre&gt;
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "forretningsAdresse",
                    "postAdresse"
                })
                public static class Adresse {

                    protected AdresseType2 forretningsAdresse;
                    protected AdresseType2 postAdresse;

                    /**
                     * Gets the value of the forretningsAdresse property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link AdresseType2 }
                     *     
                     */
                    public AdresseType2 getForretningsAdresse() {
                        return forretningsAdresse;
                    }

                    /**
                     * Sets the value of the forretningsAdresse property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link AdresseType2 }
                     *     
                     */
                    public void setForretningsAdresse(AdresseType2 value) {
                        this.forretningsAdresse = value;
                    }

                    /**
                     * Gets the value of the postAdresse property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link AdresseType2 }
                     *     
                     */
                    public AdresseType2 getPostAdresse() {
                        return postAdresse;
                    }

                    /**
                     * Sets the value of the postAdresse property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link AdresseType2 }
                     *     
                     */
                    public void setPostAdresse(AdresseType2 value) {
                        this.postAdresse = value;
                    }

                }


                /**
                 * &lt;p&gt;Java class for anonymous complex type.
                 * 
                 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
                 * 
                 * &lt;pre&gt;
                 * &amp;lt;complexType&amp;gt;
                 *   &amp;lt;simpleContent&amp;gt;
                 *     &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;int"&amp;gt;
                 *       &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
                 *     &amp;lt;/extension&amp;gt;
                 *   &amp;lt;/simpleContent&amp;gt;
                 * &amp;lt;/complexType&amp;gt;
                 * &lt;/pre&gt;
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "value"
                })
                public static class Orgnr {

                    @XmlValue
                    protected int value;
                    @XmlAttribute(name = "ledetekst")
                    protected String ledetekst;

                    /**
                     * Gets the value of the value property.
                     * 
                     */
                    public int getValue() {
                        return value;
                    }

                    /**
                     * Sets the value of the value property.
                     * 
                     */
                    public void setValue(int value) {
                        this.value = value;
                    }

                    /**
                     * Gets the value of the ledetekst property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getLedetekst() {
                        return ledetekst;
                    }

                    /**
                     * Sets the value of the ledetekst property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setLedetekst(String value) {
                        this.ledetekst = value;
                    }

                }


                /**
                 * &lt;p&gt;Java class for anonymous complex type.
                 * 
                 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
                 * 
                 * &lt;pre&gt;
                 * &amp;lt;complexType&amp;gt;
                 *   &amp;lt;simpleContent&amp;gt;
                 *     &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
                 *       &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
                 *     &amp;lt;/extension&amp;gt;
                 *   &amp;lt;/simpleContent&amp;gt;
                 * &amp;lt;/complexType&amp;gt;
                 * &lt;/pre&gt;
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "value"
                })
                public static class RolleBeskrivelse {

                    @XmlValue
                    protected String value;
                    @XmlAttribute(name = "ledetekst")
                    protected String ledetekst;

                    /**
                     * Gets the value of the value property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getValue() {
                        return value;
                    }

                    /**
                     * Sets the value of the value property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setValue(String value) {
                        this.value = value;
                    }

                    /**
                     * Gets the value of the ledetekst property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getLedetekst() {
                        return ledetekst;
                    }

                    /**
                     * Sets the value of the ledetekst property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setLedetekst(String value) {
                        this.ledetekst = value;
                    }

                }

            }

        }

    }


    /**
     * &lt;p&gt;Java class for anonymous complex type.
     * 
     * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
     * 
     * &lt;pre&gt;
     * &amp;lt;complexType&amp;gt;
     *   &amp;lt;complexContent&amp;gt;
     *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
     *       &amp;lt;sequence&amp;gt;
     *         &amp;lt;choice&amp;gt;
     *           &amp;lt;element name="orgnr" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
     *           &amp;lt;element name="fodselsnr"&amp;gt;
     *             &amp;lt;simpleType&amp;gt;
     *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
     *                 &amp;lt;length value="11"/&amp;gt;
     *               &amp;lt;/restriction&amp;gt;
     *             &amp;lt;/simpleType&amp;gt;
     *           &amp;lt;/element&amp;gt;
     *           &amp;lt;element name="requestID" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
     *         &amp;lt;/choice&amp;gt;
     *         &amp;lt;element name="hovedStatus" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
     *         &amp;lt;element name="underStatus"&amp;gt;
     *           &amp;lt;complexType&amp;gt;
     *             &amp;lt;complexContent&amp;gt;
     *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
     *                 &amp;lt;sequence&amp;gt;
     *                   &amp;lt;element name="underStatusMelding" maxOccurs="unbounded"&amp;gt;
     *                     &amp;lt;complexType&amp;gt;
     *                       &amp;lt;simpleContent&amp;gt;
     *                         &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
     *                           &amp;lt;attribute name="kode" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&amp;gt;
     *                         &amp;lt;/extension&amp;gt;
     *                       &amp;lt;/simpleContent&amp;gt;
     *                     &amp;lt;/complexType&amp;gt;
     *                   &amp;lt;/element&amp;gt;
     *                 &amp;lt;/sequence&amp;gt;
     *               &amp;lt;/restriction&amp;gt;
     *             &amp;lt;/complexContent&amp;gt;
     *           &amp;lt;/complexType&amp;gt;
     *         &amp;lt;/element&amp;gt;
     *       &amp;lt;/sequence&amp;gt;
     *       &amp;lt;attribute name="prossessDato" use="required" type="{http://www.w3.org/2001/XMLSchema}date" /&amp;gt;
     *       &amp;lt;attribute name="tjeneste" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
     *     &amp;lt;/restriction&amp;gt;
     *   &amp;lt;/complexContent&amp;gt;
     * &amp;lt;/complexType&amp;gt;
     * &lt;/pre&gt;
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "orgnr",
        "fodselsnr",
        "requestID",
        "hovedStatus",
        "underStatus"
    })
    public static class ResponseHeader {

        protected Integer orgnr;
        protected String fodselsnr;
        protected String requestID;
        protected int hovedStatus;
        @XmlElement(required = true)
        protected Grunndata.ResponseHeader.UnderStatus underStatus;
        @XmlAttribute(name = "prossessDato", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar prossessDato;
        @XmlAttribute(name = "tjeneste", required = true)
        protected String tjeneste;

        /**
         * Gets the value of the orgnr property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getOrgnr() {
            return orgnr;
        }

        /**
         * Sets the value of the orgnr property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setOrgnr(Integer value) {
            this.orgnr = value;
        }

        /**
         * Gets the value of the fodselsnr property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFodselsnr() {
            return fodselsnr;
        }

        /**
         * Sets the value of the fodselsnr property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFodselsnr(String value) {
            this.fodselsnr = value;
        }

        /**
         * Gets the value of the requestID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRequestID() {
            return requestID;
        }

        /**
         * Sets the value of the requestID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRequestID(String value) {
            this.requestID = value;
        }

        /**
         * Gets the value of the hovedStatus property.
         * 
         */
        public int getHovedStatus() {
            return hovedStatus;
        }

        /**
         * Sets the value of the hovedStatus property.
         * 
         */
        public void setHovedStatus(int value) {
            this.hovedStatus = value;
        }

        /**
         * Gets the value of the underStatus property.
         * 
         * @return
         *     possible object is
         *     {@link Grunndata.ResponseHeader.UnderStatus }
         *     
         */
        public Grunndata.ResponseHeader.UnderStatus getUnderStatus() {
            return underStatus;
        }

        /**
         * Sets the value of the underStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link Grunndata.ResponseHeader.UnderStatus }
         *     
         */
        public void setUnderStatus(Grunndata.ResponseHeader.UnderStatus value) {
            this.underStatus = value;
        }

        /**
         * Gets the value of the prossessDato property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getProssessDato() {
            return prossessDato;
        }

        /**
         * Sets the value of the prossessDato property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setProssessDato(XMLGregorianCalendar value) {
            this.prossessDato = value;
        }

        /**
         * Gets the value of the tjeneste property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTjeneste() {
            return tjeneste;
        }

        /**
         * Sets the value of the tjeneste property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTjeneste(String value) {
            this.tjeneste = value;
        }


        /**
         * &lt;p&gt;Java class for anonymous complex type.
         * 
         * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
         * 
         * &lt;pre&gt;
         * &amp;lt;complexType&amp;gt;
         *   &amp;lt;complexContent&amp;gt;
         *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
         *       &amp;lt;sequence&amp;gt;
         *         &amp;lt;element name="underStatusMelding" maxOccurs="unbounded"&amp;gt;
         *           &amp;lt;complexType&amp;gt;
         *             &amp;lt;simpleContent&amp;gt;
         *               &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
         *                 &amp;lt;attribute name="kode" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&amp;gt;
         *               &amp;lt;/extension&amp;gt;
         *             &amp;lt;/simpleContent&amp;gt;
         *           &amp;lt;/complexType&amp;gt;
         *         &amp;lt;/element&amp;gt;
         *       &amp;lt;/sequence&amp;gt;
         *     &amp;lt;/restriction&amp;gt;
         *   &amp;lt;/complexContent&amp;gt;
         * &amp;lt;/complexType&amp;gt;
         * &lt;/pre&gt;
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "underStatusMelding"
        })
        public static class UnderStatus {

            @XmlElement(required = true)
            protected List<Grunndata.ResponseHeader.UnderStatus.UnderStatusMelding> underStatusMelding;

            /**
             * Gets the value of the underStatusMelding property.
             * 
             * &lt;p&gt;
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the underStatusMelding property.
             * 
             * &lt;p&gt;
             * For example, to add a new item, do as follows:
             * &lt;pre&gt;
             *    getUnderStatusMelding().add(newItem);
             * &lt;/pre&gt;
             * 
             * 
             * &lt;p&gt;
             * Objects of the following type(s) are allowed in the list
             * {@link Grunndata.ResponseHeader.UnderStatus.UnderStatusMelding }
             * 
             * 
             */
            public List<Grunndata.ResponseHeader.UnderStatus.UnderStatusMelding> getUnderStatusMelding() {
                if (underStatusMelding == null) {
                    underStatusMelding = new ArrayList<Grunndata.ResponseHeader.UnderStatus.UnderStatusMelding>();
                }
                return this.underStatusMelding;
            }


            /**
             * &lt;p&gt;Java class for anonymous complex type.
             * 
             * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
             * 
             * &lt;pre&gt;
             * &amp;lt;complexType&amp;gt;
             *   &amp;lt;simpleContent&amp;gt;
             *     &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
             *       &amp;lt;attribute name="kode" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&amp;gt;
             *     &amp;lt;/extension&amp;gt;
             *   &amp;lt;/simpleContent&amp;gt;
             * &amp;lt;/complexType&amp;gt;
             * &lt;/pre&gt;
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class UnderStatusMelding {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "kode", required = true)
                protected int kode;

                /**
                 * Gets the value of the value property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the kode property.
                 * 
                 */
                public int getKode() {
                    return kode;
                }

                /**
                 * Sets the value of the kode property.
                 * 
                 */
                public void setKode(int value) {
                    this.kode = value;
                }

            }

        }

    }

}
