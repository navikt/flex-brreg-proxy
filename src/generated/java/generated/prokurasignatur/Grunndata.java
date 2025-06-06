
package generated.prokurasignatur;

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
 *                   &amp;lt;element name="orgnr" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
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
 *                 &amp;lt;attribute name="tjeneste" use="required"&amp;gt;
 *                   &amp;lt;simpleType&amp;gt;
 *                     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *                       &amp;lt;minLength value="1"/&amp;gt;
 *                       &amp;lt;maxLength value="40"/&amp;gt;
 *                     &amp;lt;/restriction&amp;gt;
 *                   &amp;lt;/simpleType&amp;gt;
 *                 &amp;lt;/attribute&amp;gt;
 *               &amp;lt;/restriction&amp;gt;
 *             &amp;lt;/complexContent&amp;gt;
 *           &amp;lt;/complexType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="melding" minOccurs="0"&amp;gt;
 *           &amp;lt;complexType&amp;gt;
 *             &amp;lt;complexContent&amp;gt;
 *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                 &amp;lt;sequence&amp;gt;
 *                   &amp;lt;element name="organisasjonsnummer"&amp;gt;
 *                     &amp;lt;complexType&amp;gt;
 *                       &amp;lt;simpleContent&amp;gt;
 *                         &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
 *                           &amp;lt;attribute name="registreringsDato" use="required" type="{http://www.w3.org/2001/XMLSchema}date" /&amp;gt;
 *                         &amp;lt;/extension&amp;gt;
 *                       &amp;lt;/simpleContent&amp;gt;
 *                     &amp;lt;/complexType&amp;gt;
 *                   &amp;lt;/element&amp;gt;
 *                   &amp;lt;element name="prokura" minOccurs="0"&amp;gt;
 *                     &amp;lt;complexType&amp;gt;
 *                       &amp;lt;complexContent&amp;gt;
 *                         &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                           &amp;lt;group ref="{}samendring"/&amp;gt;
 *                         &amp;lt;/restriction&amp;gt;
 *                       &amp;lt;/complexContent&amp;gt;
 *                     &amp;lt;/complexType&amp;gt;
 *                   &amp;lt;/element&amp;gt;
 *                   &amp;lt;element name="signatur" minOccurs="0"&amp;gt;
 *                     &amp;lt;complexType&amp;gt;
 *                       &amp;lt;complexContent&amp;gt;
 *                         &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *                           &amp;lt;group ref="{}samendring"/&amp;gt;
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
     *         &amp;lt;element name="organisasjonsnummer"&amp;gt;
     *           &amp;lt;complexType&amp;gt;
     *             &amp;lt;simpleContent&amp;gt;
     *               &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
     *                 &amp;lt;attribute name="registreringsDato" use="required" type="{http://www.w3.org/2001/XMLSchema}date" /&amp;gt;
     *               &amp;lt;/extension&amp;gt;
     *             &amp;lt;/simpleContent&amp;gt;
     *           &amp;lt;/complexType&amp;gt;
     *         &amp;lt;/element&amp;gt;
     *         &amp;lt;element name="prokura" minOccurs="0"&amp;gt;
     *           &amp;lt;complexType&amp;gt;
     *             &amp;lt;complexContent&amp;gt;
     *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
     *                 &amp;lt;group ref="{}samendring"/&amp;gt;
     *               &amp;lt;/restriction&amp;gt;
     *             &amp;lt;/complexContent&amp;gt;
     *           &amp;lt;/complexType&amp;gt;
     *         &amp;lt;/element&amp;gt;
     *         &amp;lt;element name="signatur" minOccurs="0"&amp;gt;
     *           &amp;lt;complexType&amp;gt;
     *             &amp;lt;complexContent&amp;gt;
     *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
     *                 &amp;lt;group ref="{}samendring"/&amp;gt;
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
        "organisasjonsnummer",
        "prokura",
        "signatur"
    })
    public static class Melding {

        @XmlElement(required = true)
        protected Grunndata.Melding.Organisasjonsnummer organisasjonsnummer;
        protected Grunndata.Melding.Prokura prokura;
        protected Grunndata.Melding.Signatur signatur;
        @XmlAttribute(name = "tjeneste", required = true)
        protected String tjeneste;

        /**
         * Gets the value of the organisasjonsnummer property.
         * 
         * @return
         *     possible object is
         *     {@link Grunndata.Melding.Organisasjonsnummer }
         *     
         */
        public Grunndata.Melding.Organisasjonsnummer getOrganisasjonsnummer() {
            return organisasjonsnummer;
        }

        /**
         * Sets the value of the organisasjonsnummer property.
         * 
         * @param value
         *     allowed object is
         *     {@link Grunndata.Melding.Organisasjonsnummer }
         *     
         */
        public void setOrganisasjonsnummer(Grunndata.Melding.Organisasjonsnummer value) {
            this.organisasjonsnummer = value;
        }

        /**
         * Gets the value of the prokura property.
         * 
         * @return
         *     possible object is
         *     {@link Grunndata.Melding.Prokura }
         *     
         */
        public Grunndata.Melding.Prokura getProkura() {
            return prokura;
        }

        /**
         * Sets the value of the prokura property.
         * 
         * @param value
         *     allowed object is
         *     {@link Grunndata.Melding.Prokura }
         *     
         */
        public void setProkura(Grunndata.Melding.Prokura value) {
            this.prokura = value;
        }

        /**
         * Gets the value of the signatur property.
         * 
         * @return
         *     possible object is
         *     {@link Grunndata.Melding.Signatur }
         *     
         */
        public Grunndata.Melding.Signatur getSignatur() {
            return signatur;
        }

        /**
         * Sets the value of the signatur property.
         * 
         * @param value
         *     allowed object is
         *     {@link Grunndata.Melding.Signatur }
         *     
         */
        public void setSignatur(Grunndata.Melding.Signatur value) {
            this.signatur = value;
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
         *   &amp;lt;simpleContent&amp;gt;
         *     &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
         *       &amp;lt;attribute name="registreringsDato" use="required" type="{http://www.w3.org/2001/XMLSchema}date" /&amp;gt;
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
        public static class Organisasjonsnummer {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "registreringsDato", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar registreringsDato;

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
         *       &amp;lt;group ref="{}samendring"/&amp;gt;
         *     &amp;lt;/restriction&amp;gt;
         *   &amp;lt;/complexContent&amp;gt;
         * &amp;lt;/complexType&amp;gt;
         * &lt;/pre&gt;
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "samendring"
        })
        public static class Prokura {

            @XmlElement(required = true)
            protected List<Grunndata.Melding.Signatur.Samendring> samendring;

            /**
             * Gets the value of the samendring property.
             * 
             * &lt;p&gt;
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the samendring property.
             * 
             * &lt;p&gt;
             * For example, to add a new item, do as follows:
             * &lt;pre&gt;
             *    getSamendring().add(newItem);
             * &lt;/pre&gt;
             * 
             * 
             * &lt;p&gt;
             * Objects of the following type(s) are allowed in the list
             * {@link Grunndata.Melding.Signatur.Samendring }
             * 
             * 
             */
            public List<Grunndata.Melding.Signatur.Samendring> getSamendring() {
                if (samendring == null) {
                    samendring = new ArrayList<Grunndata.Melding.Signatur.Samendring>();
                }
                return this.samendring;
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
         *       &amp;lt;group ref="{}samendring"/&amp;gt;
         *     &amp;lt;/restriction&amp;gt;
         *   &amp;lt;/complexContent&amp;gt;
         * &amp;lt;/complexType&amp;gt;
         * &lt;/pre&gt;
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "samendring"
        })
        public static class Signatur {

            @XmlElement(required = true)
            protected List<Grunndata.Melding.Signatur.Samendring> samendring;

            /**
             * Gets the value of the samendring property.
             * 
             * &lt;p&gt;
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the samendring property.
             * 
             * &lt;p&gt;
             * For example, to add a new item, do as follows:
             * &lt;pre&gt;
             *    getSamendring().add(newItem);
             * &lt;/pre&gt;
             * 
             * 
             * &lt;p&gt;
             * Objects of the following type(s) are allowed in the list
             * {@link Grunndata.Melding.Signatur.Samendring }
             * 
             * 
             */
            public List<Grunndata.Melding.Signatur.Samendring> getSamendring() {
                if (samendring == null) {
                    samendring = new ArrayList<Grunndata.Melding.Signatur.Samendring>();
                }
                return this.samendring;
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
             *         &amp;lt;element name="headerTekst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
             *         &amp;lt;element name="rolle" maxOccurs="unbounded" minOccurs="0"&amp;gt;
             *           &amp;lt;complexType&amp;gt;
             *             &amp;lt;complexContent&amp;gt;
             *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
             *                 &amp;lt;sequence&amp;gt;
             *                   &amp;lt;element name="person" maxOccurs="unbounded" minOccurs="0"&amp;gt;
             *                     &amp;lt;complexType&amp;gt;
             *                       &amp;lt;complexContent&amp;gt;
             *                         &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
             *                           &amp;lt;sequence&amp;gt;
             *                             &amp;lt;element name="vergeTekst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
             *                             &amp;lt;choice&amp;gt;
             *                               &amp;lt;element name="fodselsnr"&amp;gt;
             *                                 &amp;lt;simpleType&amp;gt;
             *                                   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                     &amp;lt;length value="11"/&amp;gt;
             *                                   &amp;lt;/restriction&amp;gt;
             *                                 &amp;lt;/simpleType&amp;gt;
             *                               &amp;lt;/element&amp;gt;
             *                               &amp;lt;element name="fodselsdato"&amp;gt;
             *                                 &amp;lt;simpleType&amp;gt;
             *                                   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                     &amp;lt;length value="10"/&amp;gt;
             *                                   &amp;lt;/restriction&amp;gt;
             *                                 &amp;lt;/simpleType&amp;gt;
             *                               &amp;lt;/element&amp;gt;
             *                             &amp;lt;/choice&amp;gt;
             *                             &amp;lt;element name="fornavn"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;minLength value="1"/&amp;gt;
             *                                   &amp;lt;maxLength value="50"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="mellomnavn" minOccurs="0"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;minLength value="1"/&amp;gt;
             *                                   &amp;lt;maxLength value="50"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="slektsnavn"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;minLength value="1"/&amp;gt;
             *                                   &amp;lt;maxLength value="50"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="adresse1" minOccurs="0"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;minLength value="1"/&amp;gt;
             *                                   &amp;lt;maxLength value="35"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="adresse2" minOccurs="0"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;minLength value="1"/&amp;gt;
             *                                   &amp;lt;maxLength value="35"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="adresse3" minOccurs="0"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;minLength value="1"/&amp;gt;
             *                                   &amp;lt;maxLength value="35"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="postnr" minOccurs="0"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;minLength value="4"/&amp;gt;
             *                                   &amp;lt;maxLength value="9"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="poststed" minOccurs="0"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;minLength value="1"/&amp;gt;
             *                                   &amp;lt;maxLength value="35"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="land" minOccurs="0"&amp;gt;
             *                               &amp;lt;complexType&amp;gt;
             *                                 &amp;lt;simpleContent&amp;gt;
             *                                   &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
             *                                     &amp;lt;attribute name="landkode4" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
             *                                   &amp;lt;/extension&amp;gt;
             *                                 &amp;lt;/simpleContent&amp;gt;
             *                               &amp;lt;/complexType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="valgtAv" minOccurs="0"&amp;gt;
             *                               &amp;lt;complexType&amp;gt;
             *                                 &amp;lt;simpleContent&amp;gt;
             *                                   &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
             *                                     &amp;lt;attribute name="kode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
             *                                   &amp;lt;/extension&amp;gt;
             *                                 &amp;lt;/simpleContent&amp;gt;
             *                               &amp;lt;/complexType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="ansvarsandel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
             *                             &amp;lt;element name="fratraadt" minOccurs="0"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;length value="1"/&amp;gt;
             *                                   &amp;lt;enumeration value="K"/&amp;gt;
             *                                   &amp;lt;enumeration value="R"/&amp;gt;
             *                                   &amp;lt;enumeration value="F"/&amp;gt;
             *                                   &amp;lt;enumeration value="N"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="fratraadtTekst" minOccurs="0"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;length value="8"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="revisorKategori" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
             *                             &amp;lt;element name="revisorRkode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
             *                             &amp;lt;element name="reTekst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
             *                             &amp;lt;element name="rolleFritekst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
             *                           &amp;lt;/sequence&amp;gt;
             *                           &amp;lt;attribute name="beskrivelse" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
             *                           &amp;lt;attribute name="statuskode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
             *                         &amp;lt;/restriction&amp;gt;
             *                       &amp;lt;/complexContent&amp;gt;
             *                     &amp;lt;/complexType&amp;gt;
             *                   &amp;lt;/element&amp;gt;
             *                   &amp;lt;element name="enhet" maxOccurs="unbounded" minOccurs="0"&amp;gt;
             *                     &amp;lt;complexType&amp;gt;
             *                       &amp;lt;complexContent&amp;gt;
             *                         &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
             *                           &amp;lt;sequence&amp;gt;
             *                             &amp;lt;element name="orgnr"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;length value="9"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="navn1"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;minLength value="1"/&amp;gt;
             *                                   &amp;lt;maxLength value="35"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="navn2" minOccurs="0"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;minLength value="1"/&amp;gt;
             *                                   &amp;lt;maxLength value="35"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="navn3" minOccurs="0"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;minLength value="1"/&amp;gt;
             *                                   &amp;lt;maxLength value="35"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="navn4" minOccurs="0"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;minLength value="1"/&amp;gt;
             *                                   &amp;lt;maxLength value="35"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="navn5" minOccurs="0"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;minLength value="1"/&amp;gt;
             *                                   &amp;lt;maxLength value="35"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="adresse1" minOccurs="0"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;minLength value="1"/&amp;gt;
             *                                   &amp;lt;maxLength value="35"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="adresse2" minOccurs="0"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;minLength value="1"/&amp;gt;
             *                                   &amp;lt;maxLength value="35"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="adresse3" minOccurs="0"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;minLength value="1"/&amp;gt;
             *                                   &amp;lt;maxLength value="35"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="postnr" minOccurs="0"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;minLength value="4"/&amp;gt;
             *                                   &amp;lt;maxLength value="9"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="poststed" minOccurs="0"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;minLength value="1"/&amp;gt;
             *                                   &amp;lt;maxLength value="35"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="land" minOccurs="0"&amp;gt;
             *                               &amp;lt;complexType&amp;gt;
             *                                 &amp;lt;simpleContent&amp;gt;
             *                                   &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
             *                                     &amp;lt;attribute name="landkode4" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
             *                                   &amp;lt;/extension&amp;gt;
             *                                 &amp;lt;/simpleContent&amp;gt;
             *                               &amp;lt;/complexType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="valgtAv" minOccurs="0"&amp;gt;
             *                               &amp;lt;complexType&amp;gt;
             *                                 &amp;lt;simpleContent&amp;gt;
             *                                   &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
             *                                     &amp;lt;attribute name="kode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
             *                                   &amp;lt;/extension&amp;gt;
             *                                 &amp;lt;/simpleContent&amp;gt;
             *                               &amp;lt;/complexType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="ansvarsandel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
             *                             &amp;lt;element name="fratraadt" minOccurs="0"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;length value="1"/&amp;gt;
             *                                   &amp;lt;enumeration value="K"/&amp;gt;
             *                                   &amp;lt;enumeration value="R"/&amp;gt;
             *                                   &amp;lt;enumeration value="F"/&amp;gt;
             *                                   &amp;lt;enumeration value="N"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="fratraadtTekst" minOccurs="0"&amp;gt;
             *                               &amp;lt;simpleType&amp;gt;
             *                                 &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
             *                                   &amp;lt;length value="8"/&amp;gt;
             *                                 &amp;lt;/restriction&amp;gt;
             *                               &amp;lt;/simpleType&amp;gt;
             *                             &amp;lt;/element&amp;gt;
             *                             &amp;lt;element name="revisorKategori" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
             *                             &amp;lt;element name="revisorRkode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
             *                             &amp;lt;element name="reTekst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
             *                             &amp;lt;element name="rolleFritekst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
             *                           &amp;lt;/sequence&amp;gt;
             *                           &amp;lt;attribute name="beskrivelse" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
             *                           &amp;lt;attribute name="statuskode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
             *                         &amp;lt;/restriction&amp;gt;
             *                       &amp;lt;/complexContent&amp;gt;
             *                     &amp;lt;/complexType&amp;gt;
             *                   &amp;lt;/element&amp;gt;
             *                 &amp;lt;/sequence&amp;gt;
             *                 &amp;lt;attribute name="beskrivelse" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
             *                 &amp;lt;attribute name="rolletype" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
             *               &amp;lt;/restriction&amp;gt;
             *             &amp;lt;/complexContent&amp;gt;
             *           &amp;lt;/complexType&amp;gt;
             *         &amp;lt;/element&amp;gt;
             *         &amp;lt;element name="trailerTekst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
             *       &amp;lt;/sequence&amp;gt;
             *       &amp;lt;attribute name="registreringsDato" use="required" type="{http://www.w3.org/2001/XMLSchema}date" /&amp;gt;
             *       &amp;lt;attribute name="beskrivelse" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
             *       &amp;lt;attribute name="samendringstype" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
             *     &amp;lt;/restriction&amp;gt;
             *   &amp;lt;/complexContent&amp;gt;
             * &amp;lt;/complexType&amp;gt;
             * &lt;/pre&gt;
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "headerTekst",
                "rolle",
                "trailerTekst"
            })
            public static class Samendring {

                protected String headerTekst;
                protected List<Grunndata.Melding.Signatur.Samendring.Rolle> rolle;
                protected String trailerTekst;
                @XmlAttribute(name = "registreringsDato", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar registreringsDato;
                @XmlAttribute(name = "beskrivelse", required = true)
                protected String beskrivelse;
                @XmlAttribute(name = "samendringstype", required = true)
                protected String samendringstype;

                /**
                 * Gets the value of the headerTekst property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getHeaderTekst() {
                    return headerTekst;
                }

                /**
                 * Sets the value of the headerTekst property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setHeaderTekst(String value) {
                    this.headerTekst = value;
                }

                /**
                 * Gets the value of the rolle property.
                 * 
                 * &lt;p&gt;
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the rolle property.
                 * 
                 * &lt;p&gt;
                 * For example, to add a new item, do as follows:
                 * &lt;pre&gt;
                 *    getRolle().add(newItem);
                 * &lt;/pre&gt;
                 * 
                 * 
                 * &lt;p&gt;
                 * Objects of the following type(s) are allowed in the list
                 * {@link Grunndata.Melding.Signatur.Samendring.Rolle }
                 * 
                 * 
                 */
                public List<Grunndata.Melding.Signatur.Samendring.Rolle> getRolle() {
                    if (rolle == null) {
                        rolle = new ArrayList<Grunndata.Melding.Signatur.Samendring.Rolle>();
                    }
                    return this.rolle;
                }

                /**
                 * Gets the value of the trailerTekst property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTrailerTekst() {
                    return trailerTekst;
                }

                /**
                 * Sets the value of the trailerTekst property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTrailerTekst(String value) {
                    this.trailerTekst = value;
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
                 * Gets the value of the beskrivelse property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getBeskrivelse() {
                    return beskrivelse;
                }

                /**
                 * Sets the value of the beskrivelse property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setBeskrivelse(String value) {
                    this.beskrivelse = value;
                }

                /**
                 * Gets the value of the samendringstype property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getSamendringstype() {
                    return samendringstype;
                }

                /**
                 * Sets the value of the samendringstype property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setSamendringstype(String value) {
                    this.samendringstype = value;
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
                 *         &amp;lt;element name="person" maxOccurs="unbounded" minOccurs="0"&amp;gt;
                 *           &amp;lt;complexType&amp;gt;
                 *             &amp;lt;complexContent&amp;gt;
                 *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
                 *                 &amp;lt;sequence&amp;gt;
                 *                   &amp;lt;element name="vergeTekst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
                 *                   &amp;lt;choice&amp;gt;
                 *                     &amp;lt;element name="fodselsnr"&amp;gt;
                 *                       &amp;lt;simpleType&amp;gt;
                 *                         &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                           &amp;lt;length value="11"/&amp;gt;
                 *                         &amp;lt;/restriction&amp;gt;
                 *                       &amp;lt;/simpleType&amp;gt;
                 *                     &amp;lt;/element&amp;gt;
                 *                     &amp;lt;element name="fodselsdato"&amp;gt;
                 *                       &amp;lt;simpleType&amp;gt;
                 *                         &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                           &amp;lt;length value="10"/&amp;gt;
                 *                         &amp;lt;/restriction&amp;gt;
                 *                       &amp;lt;/simpleType&amp;gt;
                 *                     &amp;lt;/element&amp;gt;
                 *                   &amp;lt;/choice&amp;gt;
                 *                   &amp;lt;element name="fornavn"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;minLength value="1"/&amp;gt;
                 *                         &amp;lt;maxLength value="50"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="mellomnavn" minOccurs="0"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;minLength value="1"/&amp;gt;
                 *                         &amp;lt;maxLength value="50"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="slektsnavn"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;minLength value="1"/&amp;gt;
                 *                         &amp;lt;maxLength value="50"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="adresse1" minOccurs="0"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;minLength value="1"/&amp;gt;
                 *                         &amp;lt;maxLength value="35"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="adresse2" minOccurs="0"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;minLength value="1"/&amp;gt;
                 *                         &amp;lt;maxLength value="35"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="adresse3" minOccurs="0"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;minLength value="1"/&amp;gt;
                 *                         &amp;lt;maxLength value="35"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="postnr" minOccurs="0"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;minLength value="4"/&amp;gt;
                 *                         &amp;lt;maxLength value="9"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="poststed" minOccurs="0"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;minLength value="1"/&amp;gt;
                 *                         &amp;lt;maxLength value="35"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="land" minOccurs="0"&amp;gt;
                 *                     &amp;lt;complexType&amp;gt;
                 *                       &amp;lt;simpleContent&amp;gt;
                 *                         &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
                 *                           &amp;lt;attribute name="landkode4" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
                 *                         &amp;lt;/extension&amp;gt;
                 *                       &amp;lt;/simpleContent&amp;gt;
                 *                     &amp;lt;/complexType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="valgtAv" minOccurs="0"&amp;gt;
                 *                     &amp;lt;complexType&amp;gt;
                 *                       &amp;lt;simpleContent&amp;gt;
                 *                         &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
                 *                           &amp;lt;attribute name="kode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
                 *                         &amp;lt;/extension&amp;gt;
                 *                       &amp;lt;/simpleContent&amp;gt;
                 *                     &amp;lt;/complexType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="ansvarsandel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
                 *                   &amp;lt;element name="fratraadt" minOccurs="0"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;length value="1"/&amp;gt;
                 *                         &amp;lt;enumeration value="K"/&amp;gt;
                 *                         &amp;lt;enumeration value="R"/&amp;gt;
                 *                         &amp;lt;enumeration value="F"/&amp;gt;
                 *                         &amp;lt;enumeration value="N"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="fratraadtTekst" minOccurs="0"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;length value="8"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="revisorKategori" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
                 *                   &amp;lt;element name="revisorRkode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
                 *                   &amp;lt;element name="reTekst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
                 *                   &amp;lt;element name="rolleFritekst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
                 *                 &amp;lt;/sequence&amp;gt;
                 *                 &amp;lt;attribute name="beskrivelse" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
                 *                 &amp;lt;attribute name="statuskode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
                 *               &amp;lt;/restriction&amp;gt;
                 *             &amp;lt;/complexContent&amp;gt;
                 *           &amp;lt;/complexType&amp;gt;
                 *         &amp;lt;/element&amp;gt;
                 *         &amp;lt;element name="enhet" maxOccurs="unbounded" minOccurs="0"&amp;gt;
                 *           &amp;lt;complexType&amp;gt;
                 *             &amp;lt;complexContent&amp;gt;
                 *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
                 *                 &amp;lt;sequence&amp;gt;
                 *                   &amp;lt;element name="orgnr"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;length value="9"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="navn1"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;minLength value="1"/&amp;gt;
                 *                         &amp;lt;maxLength value="35"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="navn2" minOccurs="0"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;minLength value="1"/&amp;gt;
                 *                         &amp;lt;maxLength value="35"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="navn3" minOccurs="0"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;minLength value="1"/&amp;gt;
                 *                         &amp;lt;maxLength value="35"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="navn4" minOccurs="0"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;minLength value="1"/&amp;gt;
                 *                         &amp;lt;maxLength value="35"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="navn5" minOccurs="0"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;minLength value="1"/&amp;gt;
                 *                         &amp;lt;maxLength value="35"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="adresse1" minOccurs="0"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;minLength value="1"/&amp;gt;
                 *                         &amp;lt;maxLength value="35"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="adresse2" minOccurs="0"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;minLength value="1"/&amp;gt;
                 *                         &amp;lt;maxLength value="35"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="adresse3" minOccurs="0"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;minLength value="1"/&amp;gt;
                 *                         &amp;lt;maxLength value="35"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="postnr" minOccurs="0"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;minLength value="4"/&amp;gt;
                 *                         &amp;lt;maxLength value="9"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="poststed" minOccurs="0"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;minLength value="1"/&amp;gt;
                 *                         &amp;lt;maxLength value="35"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="land" minOccurs="0"&amp;gt;
                 *                     &amp;lt;complexType&amp;gt;
                 *                       &amp;lt;simpleContent&amp;gt;
                 *                         &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
                 *                           &amp;lt;attribute name="landkode4" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
                 *                         &amp;lt;/extension&amp;gt;
                 *                       &amp;lt;/simpleContent&amp;gt;
                 *                     &amp;lt;/complexType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="valgtAv" minOccurs="0"&amp;gt;
                 *                     &amp;lt;complexType&amp;gt;
                 *                       &amp;lt;simpleContent&amp;gt;
                 *                         &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
                 *                           &amp;lt;attribute name="kode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
                 *                         &amp;lt;/extension&amp;gt;
                 *                       &amp;lt;/simpleContent&amp;gt;
                 *                     &amp;lt;/complexType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="ansvarsandel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
                 *                   &amp;lt;element name="fratraadt" minOccurs="0"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;length value="1"/&amp;gt;
                 *                         &amp;lt;enumeration value="K"/&amp;gt;
                 *                         &amp;lt;enumeration value="R"/&amp;gt;
                 *                         &amp;lt;enumeration value="F"/&amp;gt;
                 *                         &amp;lt;enumeration value="N"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="fratraadtTekst" minOccurs="0"&amp;gt;
                 *                     &amp;lt;simpleType&amp;gt;
                 *                       &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                 *                         &amp;lt;length value="8"/&amp;gt;
                 *                       &amp;lt;/restriction&amp;gt;
                 *                     &amp;lt;/simpleType&amp;gt;
                 *                   &amp;lt;/element&amp;gt;
                 *                   &amp;lt;element name="revisorKategori" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
                 *                   &amp;lt;element name="revisorRkode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
                 *                   &amp;lt;element name="reTekst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
                 *                   &amp;lt;element name="rolleFritekst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
                 *                 &amp;lt;/sequence&amp;gt;
                 *                 &amp;lt;attribute name="beskrivelse" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
                 *                 &amp;lt;attribute name="statuskode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
                 *               &amp;lt;/restriction&amp;gt;
                 *             &amp;lt;/complexContent&amp;gt;
                 *           &amp;lt;/complexType&amp;gt;
                 *         &amp;lt;/element&amp;gt;
                 *       &amp;lt;/sequence&amp;gt;
                 *       &amp;lt;attribute name="beskrivelse" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
                 *       &amp;lt;attribute name="rolletype" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
                 *     &amp;lt;/restriction&amp;gt;
                 *   &amp;lt;/complexContent&amp;gt;
                 * &amp;lt;/complexType&amp;gt;
                 * &lt;/pre&gt;
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "person",
                    "enhet"
                })
                public static class Rolle {

                    protected List<Grunndata.Melding.Signatur.Samendring.Rolle.Person> person;
                    protected List<Grunndata.Melding.Signatur.Samendring.Rolle.Enhet> enhet;
                    @XmlAttribute(name = "beskrivelse", required = true)
                    protected String beskrivelse;
                    @XmlAttribute(name = "rolletype", required = true)
                    protected String rolletype;

                    /**
                     * Gets the value of the person property.
                     * 
                     * &lt;p&gt;
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the person property.
                     * 
                     * &lt;p&gt;
                     * For example, to add a new item, do as follows:
                     * &lt;pre&gt;
                     *    getPerson().add(newItem);
                     * &lt;/pre&gt;
                     * 
                     * 
                     * &lt;p&gt;
                     * Objects of the following type(s) are allowed in the list
                     * {@link Grunndata.Melding.Signatur.Samendring.Rolle.Person }
                     * 
                     * 
                     */
                    public List<Grunndata.Melding.Signatur.Samendring.Rolle.Person> getPerson() {
                        if (person == null) {
                            person = new ArrayList<Grunndata.Melding.Signatur.Samendring.Rolle.Person>();
                        }
                        return this.person;
                    }

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
                     * {@link Grunndata.Melding.Signatur.Samendring.Rolle.Enhet }
                     * 
                     * 
                     */
                    public List<Grunndata.Melding.Signatur.Samendring.Rolle.Enhet> getEnhet() {
                        if (enhet == null) {
                            enhet = new ArrayList<Grunndata.Melding.Signatur.Samendring.Rolle.Enhet>();
                        }
                        return this.enhet;
                    }

                    /**
                     * Gets the value of the beskrivelse property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getBeskrivelse() {
                        return beskrivelse;
                    }

                    /**
                     * Sets the value of the beskrivelse property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setBeskrivelse(String value) {
                        this.beskrivelse = value;
                    }

                    /**
                     * Gets the value of the rolletype property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getRolletype() {
                        return rolletype;
                    }

                    /**
                     * Sets the value of the rolletype property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setRolletype(String value) {
                        this.rolletype = value;
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
                     *         &amp;lt;element name="orgnr"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;length value="9"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="navn1"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;minLength value="1"/&amp;gt;
                     *               &amp;lt;maxLength value="35"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="navn2" minOccurs="0"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;minLength value="1"/&amp;gt;
                     *               &amp;lt;maxLength value="35"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="navn3" minOccurs="0"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;minLength value="1"/&amp;gt;
                     *               &amp;lt;maxLength value="35"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="navn4" minOccurs="0"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;minLength value="1"/&amp;gt;
                     *               &amp;lt;maxLength value="35"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="navn5" minOccurs="0"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;minLength value="1"/&amp;gt;
                     *               &amp;lt;maxLength value="35"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="adresse1" minOccurs="0"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;minLength value="1"/&amp;gt;
                     *               &amp;lt;maxLength value="35"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="adresse2" minOccurs="0"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;minLength value="1"/&amp;gt;
                     *               &amp;lt;maxLength value="35"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="adresse3" minOccurs="0"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;minLength value="1"/&amp;gt;
                     *               &amp;lt;maxLength value="35"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="postnr" minOccurs="0"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;minLength value="4"/&amp;gt;
                     *               &amp;lt;maxLength value="9"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="poststed" minOccurs="0"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;minLength value="1"/&amp;gt;
                     *               &amp;lt;maxLength value="35"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="land" minOccurs="0"&amp;gt;
                     *           &amp;lt;complexType&amp;gt;
                     *             &amp;lt;simpleContent&amp;gt;
                     *               &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
                     *                 &amp;lt;attribute name="landkode4" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
                     *               &amp;lt;/extension&amp;gt;
                     *             &amp;lt;/simpleContent&amp;gt;
                     *           &amp;lt;/complexType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="valgtAv" minOccurs="0"&amp;gt;
                     *           &amp;lt;complexType&amp;gt;
                     *             &amp;lt;simpleContent&amp;gt;
                     *               &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
                     *                 &amp;lt;attribute name="kode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
                     *               &amp;lt;/extension&amp;gt;
                     *             &amp;lt;/simpleContent&amp;gt;
                     *           &amp;lt;/complexType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="ansvarsandel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
                     *         &amp;lt;element name="fratraadt" minOccurs="0"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;length value="1"/&amp;gt;
                     *               &amp;lt;enumeration value="K"/&amp;gt;
                     *               &amp;lt;enumeration value="R"/&amp;gt;
                     *               &amp;lt;enumeration value="F"/&amp;gt;
                     *               &amp;lt;enumeration value="N"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="fratraadtTekst" minOccurs="0"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;length value="8"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="revisorKategori" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
                     *         &amp;lt;element name="revisorRkode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
                     *         &amp;lt;element name="reTekst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
                     *         &amp;lt;element name="rolleFritekst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
                     *       &amp;lt;/sequence&amp;gt;
                     *       &amp;lt;attribute name="beskrivelse" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
                     *       &amp;lt;attribute name="statuskode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
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
                        "navn1",
                        "navn2",
                        "navn3",
                        "navn4",
                        "navn5",
                        "adresse1",
                        "adresse2",
                        "adresse3",
                        "postnr",
                        "poststed",
                        "land",
                        "valgtAv",
                        "ansvarsandel",
                        "fratraadt",
                        "fratraadtTekst",
                        "revisorKategori",
                        "revisorRkode",
                        "reTekst",
                        "rolleFritekst"
                    })
                    public static class Enhet {

                        @XmlElement(required = true)
                        protected String orgnr;
                        @XmlElement(required = true)
                        protected String navn1;
                        protected String navn2;
                        protected String navn3;
                        protected String navn4;
                        protected String navn5;
                        protected String adresse1;
                        protected String adresse2;
                        protected String adresse3;
                        protected String postnr;
                        protected String poststed;
                        protected Grunndata.Melding.Signatur.Samendring.Rolle.Enhet.Land land;
                        protected Grunndata.Melding.Signatur.Samendring.Rolle.Enhet.ValgtAv valgtAv;
                        protected String ansvarsandel;
                        protected String fratraadt;
                        protected String fratraadtTekst;
                        protected Integer revisorKategori;
                        protected Integer revisorRkode;
                        protected String reTekst;
                        protected String rolleFritekst;
                        @XmlAttribute(name = "beskrivelse", required = true)
                        protected String beskrivelse;
                        @XmlAttribute(name = "statuskode", required = true)
                        protected String statuskode;

                        /**
                         * Gets the value of the orgnr property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getOrgnr() {
                            return orgnr;
                        }

                        /**
                         * Sets the value of the orgnr property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setOrgnr(String value) {
                            this.orgnr = value;
                        }

                        /**
                         * Gets the value of the navn1 property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getNavn1() {
                            return navn1;
                        }

                        /**
                         * Sets the value of the navn1 property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setNavn1(String value) {
                            this.navn1 = value;
                        }

                        /**
                         * Gets the value of the navn2 property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getNavn2() {
                            return navn2;
                        }

                        /**
                         * Sets the value of the navn2 property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setNavn2(String value) {
                            this.navn2 = value;
                        }

                        /**
                         * Gets the value of the navn3 property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getNavn3() {
                            return navn3;
                        }

                        /**
                         * Sets the value of the navn3 property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setNavn3(String value) {
                            this.navn3 = value;
                        }

                        /**
                         * Gets the value of the navn4 property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getNavn4() {
                            return navn4;
                        }

                        /**
                         * Sets the value of the navn4 property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setNavn4(String value) {
                            this.navn4 = value;
                        }

                        /**
                         * Gets the value of the navn5 property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getNavn5() {
                            return navn5;
                        }

                        /**
                         * Sets the value of the navn5 property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setNavn5(String value) {
                            this.navn5 = value;
                        }

                        /**
                         * Gets the value of the adresse1 property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getAdresse1() {
                            return adresse1;
                        }

                        /**
                         * Sets the value of the adresse1 property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setAdresse1(String value) {
                            this.adresse1 = value;
                        }

                        /**
                         * Gets the value of the adresse2 property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getAdresse2() {
                            return adresse2;
                        }

                        /**
                         * Sets the value of the adresse2 property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setAdresse2(String value) {
                            this.adresse2 = value;
                        }

                        /**
                         * Gets the value of the adresse3 property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getAdresse3() {
                            return adresse3;
                        }

                        /**
                         * Sets the value of the adresse3 property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setAdresse3(String value) {
                            this.adresse3 = value;
                        }

                        /**
                         * Gets the value of the postnr property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getPostnr() {
                            return postnr;
                        }

                        /**
                         * Sets the value of the postnr property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setPostnr(String value) {
                            this.postnr = value;
                        }

                        /**
                         * Gets the value of the poststed property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getPoststed() {
                            return poststed;
                        }

                        /**
                         * Sets the value of the poststed property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setPoststed(String value) {
                            this.poststed = value;
                        }

                        /**
                         * Gets the value of the land property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link Grunndata.Melding.Signatur.Samendring.Rolle.Enhet.Land }
                         *     
                         */
                        public Grunndata.Melding.Signatur.Samendring.Rolle.Enhet.Land getLand() {
                            return land;
                        }

                        /**
                         * Sets the value of the land property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link Grunndata.Melding.Signatur.Samendring.Rolle.Enhet.Land }
                         *     
                         */
                        public void setLand(Grunndata.Melding.Signatur.Samendring.Rolle.Enhet.Land value) {
                            this.land = value;
                        }

                        /**
                         * Gets the value of the valgtAv property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link Grunndata.Melding.Signatur.Samendring.Rolle.Enhet.ValgtAv }
                         *     
                         */
                        public Grunndata.Melding.Signatur.Samendring.Rolle.Enhet.ValgtAv getValgtAv() {
                            return valgtAv;
                        }

                        /**
                         * Sets the value of the valgtAv property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link Grunndata.Melding.Signatur.Samendring.Rolle.Enhet.ValgtAv }
                         *     
                         */
                        public void setValgtAv(Grunndata.Melding.Signatur.Samendring.Rolle.Enhet.ValgtAv value) {
                            this.valgtAv = value;
                        }

                        /**
                         * Gets the value of the ansvarsandel property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getAnsvarsandel() {
                            return ansvarsandel;
                        }

                        /**
                         * Sets the value of the ansvarsandel property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setAnsvarsandel(String value) {
                            this.ansvarsandel = value;
                        }

                        /**
                         * Gets the value of the fratraadt property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getFratraadt() {
                            return fratraadt;
                        }

                        /**
                         * Sets the value of the fratraadt property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setFratraadt(String value) {
                            this.fratraadt = value;
                        }

                        /**
                         * Gets the value of the fratraadtTekst property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getFratraadtTekst() {
                            return fratraadtTekst;
                        }

                        /**
                         * Sets the value of the fratraadtTekst property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setFratraadtTekst(String value) {
                            this.fratraadtTekst = value;
                        }

                        /**
                         * Gets the value of the revisorKategori property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link Integer }
                         *     
                         */
                        public Integer getRevisorKategori() {
                            return revisorKategori;
                        }

                        /**
                         * Sets the value of the revisorKategori property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link Integer }
                         *     
                         */
                        public void setRevisorKategori(Integer value) {
                            this.revisorKategori = value;
                        }

                        /**
                         * Gets the value of the revisorRkode property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link Integer }
                         *     
                         */
                        public Integer getRevisorRkode() {
                            return revisorRkode;
                        }

                        /**
                         * Sets the value of the revisorRkode property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link Integer }
                         *     
                         */
                        public void setRevisorRkode(Integer value) {
                            this.revisorRkode = value;
                        }

                        /**
                         * Gets the value of the reTekst property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getReTekst() {
                            return reTekst;
                        }

                        /**
                         * Sets the value of the reTekst property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setReTekst(String value) {
                            this.reTekst = value;
                        }

                        /**
                         * Gets the value of the rolleFritekst property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getRolleFritekst() {
                            return rolleFritekst;
                        }

                        /**
                         * Sets the value of the rolleFritekst property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setRolleFritekst(String value) {
                            this.rolleFritekst = value;
                        }

                        /**
                         * Gets the value of the beskrivelse property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getBeskrivelse() {
                            return beskrivelse;
                        }

                        /**
                         * Sets the value of the beskrivelse property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setBeskrivelse(String value) {
                            this.beskrivelse = value;
                        }

                        /**
                         * Gets the value of the statuskode property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getStatuskode() {
                            return statuskode;
                        }

                        /**
                         * Sets the value of the statuskode property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setStatuskode(String value) {
                            this.statuskode = value;
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
                         *       &amp;lt;attribute name="landkode4" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
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
                        public static class Land {

                            @XmlValue
                            protected String value;
                            @XmlAttribute(name = "landkode4", required = true)
                            protected String landkode4;

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
                             * Gets the value of the landkode4 property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getLandkode4() {
                                return landkode4;
                            }

                            /**
                             * Sets the value of the landkode4 property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setLandkode4(String value) {
                                this.landkode4 = value;
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
                         *       &amp;lt;attribute name="kode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
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
                        public static class ValgtAv {

                            @XmlValue
                            protected String value;
                            @XmlAttribute(name = "kode", required = true)
                            protected String kode;

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
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getKode() {
                                return kode;
                            }

                            /**
                             * Sets the value of the kode property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setKode(String value) {
                                this.kode = value;
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
                     *         &amp;lt;element name="vergeTekst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
                     *         &amp;lt;choice&amp;gt;
                     *           &amp;lt;element name="fodselsnr"&amp;gt;
                     *             &amp;lt;simpleType&amp;gt;
                     *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *                 &amp;lt;length value="11"/&amp;gt;
                     *               &amp;lt;/restriction&amp;gt;
                     *             &amp;lt;/simpleType&amp;gt;
                     *           &amp;lt;/element&amp;gt;
                     *           &amp;lt;element name="fodselsdato"&amp;gt;
                     *             &amp;lt;simpleType&amp;gt;
                     *               &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *                 &amp;lt;length value="10"/&amp;gt;
                     *               &amp;lt;/restriction&amp;gt;
                     *             &amp;lt;/simpleType&amp;gt;
                     *           &amp;lt;/element&amp;gt;
                     *         &amp;lt;/choice&amp;gt;
                     *         &amp;lt;element name="fornavn"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;minLength value="1"/&amp;gt;
                     *               &amp;lt;maxLength value="50"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="mellomnavn" minOccurs="0"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;minLength value="1"/&amp;gt;
                     *               &amp;lt;maxLength value="50"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="slektsnavn"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;minLength value="1"/&amp;gt;
                     *               &amp;lt;maxLength value="50"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="adresse1" minOccurs="0"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;minLength value="1"/&amp;gt;
                     *               &amp;lt;maxLength value="35"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="adresse2" minOccurs="0"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;minLength value="1"/&amp;gt;
                     *               &amp;lt;maxLength value="35"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="adresse3" minOccurs="0"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;minLength value="1"/&amp;gt;
                     *               &amp;lt;maxLength value="35"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="postnr" minOccurs="0"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;minLength value="4"/&amp;gt;
                     *               &amp;lt;maxLength value="9"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="poststed" minOccurs="0"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;minLength value="1"/&amp;gt;
                     *               &amp;lt;maxLength value="35"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="land" minOccurs="0"&amp;gt;
                     *           &amp;lt;complexType&amp;gt;
                     *             &amp;lt;simpleContent&amp;gt;
                     *               &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
                     *                 &amp;lt;attribute name="landkode4" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
                     *               &amp;lt;/extension&amp;gt;
                     *             &amp;lt;/simpleContent&amp;gt;
                     *           &amp;lt;/complexType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="valgtAv" minOccurs="0"&amp;gt;
                     *           &amp;lt;complexType&amp;gt;
                     *             &amp;lt;simpleContent&amp;gt;
                     *               &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
                     *                 &amp;lt;attribute name="kode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
                     *               &amp;lt;/extension&amp;gt;
                     *             &amp;lt;/simpleContent&amp;gt;
                     *           &amp;lt;/complexType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="ansvarsandel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
                     *         &amp;lt;element name="fratraadt" minOccurs="0"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;length value="1"/&amp;gt;
                     *               &amp;lt;enumeration value="K"/&amp;gt;
                     *               &amp;lt;enumeration value="R"/&amp;gt;
                     *               &amp;lt;enumeration value="F"/&amp;gt;
                     *               &amp;lt;enumeration value="N"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="fratraadtTekst" minOccurs="0"&amp;gt;
                     *           &amp;lt;simpleType&amp;gt;
                     *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
                     *               &amp;lt;length value="8"/&amp;gt;
                     *             &amp;lt;/restriction&amp;gt;
                     *           &amp;lt;/simpleType&amp;gt;
                     *         &amp;lt;/element&amp;gt;
                     *         &amp;lt;element name="revisorKategori" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
                     *         &amp;lt;element name="revisorRkode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&amp;gt;
                     *         &amp;lt;element name="reTekst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
                     *         &amp;lt;element name="rolleFritekst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
                     *       &amp;lt;/sequence&amp;gt;
                     *       &amp;lt;attribute name="beskrivelse" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
                     *       &amp;lt;attribute name="statuskode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
                     *     &amp;lt;/restriction&amp;gt;
                     *   &amp;lt;/complexContent&amp;gt;
                     * &amp;lt;/complexType&amp;gt;
                     * &lt;/pre&gt;
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "vergeTekst",
                        "fodselsnr",
                        "fodselsdato",
                        "fornavn",
                        "mellomnavn",
                        "slektsnavn",
                        "adresse1",
                        "adresse2",
                        "adresse3",
                        "postnr",
                        "poststed",
                        "land",
                        "valgtAv",
                        "ansvarsandel",
                        "fratraadt",
                        "fratraadtTekst",
                        "revisorKategori",
                        "revisorRkode",
                        "reTekst",
                        "rolleFritekst"
                    })
                    public static class Person {

                        protected String vergeTekst;
                        protected String fodselsnr;
                        protected String fodselsdato;
                        @XmlElement(required = true)
                        protected String fornavn;
                        protected String mellomnavn;
                        @XmlElement(required = true)
                        protected String slektsnavn;
                        protected String adresse1;
                        protected String adresse2;
                        protected String adresse3;
                        protected String postnr;
                        protected String poststed;
                        protected Grunndata.Melding.Signatur.Samendring.Rolle.Person.Land land;
                        protected Grunndata.Melding.Signatur.Samendring.Rolle.Person.ValgtAv valgtAv;
                        protected String ansvarsandel;
                        protected String fratraadt;
                        protected String fratraadtTekst;
                        protected Integer revisorKategori;
                        protected Integer revisorRkode;
                        protected String reTekst;
                        protected String rolleFritekst;
                        @XmlAttribute(name = "beskrivelse", required = true)
                        protected String beskrivelse;
                        @XmlAttribute(name = "statuskode", required = true)
                        protected String statuskode;

                        /**
                         * Gets the value of the vergeTekst property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getVergeTekst() {
                            return vergeTekst;
                        }

                        /**
                         * Sets the value of the vergeTekst property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setVergeTekst(String value) {
                            this.vergeTekst = value;
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
                         * Gets the value of the fodselsdato property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getFodselsdato() {
                            return fodselsdato;
                        }

                        /**
                         * Sets the value of the fodselsdato property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setFodselsdato(String value) {
                            this.fodselsdato = value;
                        }

                        /**
                         * Gets the value of the fornavn property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getFornavn() {
                            return fornavn;
                        }

                        /**
                         * Sets the value of the fornavn property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setFornavn(String value) {
                            this.fornavn = value;
                        }

                        /**
                         * Gets the value of the mellomnavn property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getMellomnavn() {
                            return mellomnavn;
                        }

                        /**
                         * Sets the value of the mellomnavn property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setMellomnavn(String value) {
                            this.mellomnavn = value;
                        }

                        /**
                         * Gets the value of the slektsnavn property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getSlektsnavn() {
                            return slektsnavn;
                        }

                        /**
                         * Sets the value of the slektsnavn property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setSlektsnavn(String value) {
                            this.slektsnavn = value;
                        }

                        /**
                         * Gets the value of the adresse1 property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getAdresse1() {
                            return adresse1;
                        }

                        /**
                         * Sets the value of the adresse1 property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setAdresse1(String value) {
                            this.adresse1 = value;
                        }

                        /**
                         * Gets the value of the adresse2 property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getAdresse2() {
                            return adresse2;
                        }

                        /**
                         * Sets the value of the adresse2 property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setAdresse2(String value) {
                            this.adresse2 = value;
                        }

                        /**
                         * Gets the value of the adresse3 property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getAdresse3() {
                            return adresse3;
                        }

                        /**
                         * Sets the value of the adresse3 property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setAdresse3(String value) {
                            this.adresse3 = value;
                        }

                        /**
                         * Gets the value of the postnr property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getPostnr() {
                            return postnr;
                        }

                        /**
                         * Sets the value of the postnr property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setPostnr(String value) {
                            this.postnr = value;
                        }

                        /**
                         * Gets the value of the poststed property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getPoststed() {
                            return poststed;
                        }

                        /**
                         * Sets the value of the poststed property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setPoststed(String value) {
                            this.poststed = value;
                        }

                        /**
                         * Gets the value of the land property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link Grunndata.Melding.Signatur.Samendring.Rolle.Person.Land }
                         *     
                         */
                        public Grunndata.Melding.Signatur.Samendring.Rolle.Person.Land getLand() {
                            return land;
                        }

                        /**
                         * Sets the value of the land property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link Grunndata.Melding.Signatur.Samendring.Rolle.Person.Land }
                         *     
                         */
                        public void setLand(Grunndata.Melding.Signatur.Samendring.Rolle.Person.Land value) {
                            this.land = value;
                        }

                        /**
                         * Gets the value of the valgtAv property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link Grunndata.Melding.Signatur.Samendring.Rolle.Person.ValgtAv }
                         *     
                         */
                        public Grunndata.Melding.Signatur.Samendring.Rolle.Person.ValgtAv getValgtAv() {
                            return valgtAv;
                        }

                        /**
                         * Sets the value of the valgtAv property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link Grunndata.Melding.Signatur.Samendring.Rolle.Person.ValgtAv }
                         *     
                         */
                        public void setValgtAv(Grunndata.Melding.Signatur.Samendring.Rolle.Person.ValgtAv value) {
                            this.valgtAv = value;
                        }

                        /**
                         * Gets the value of the ansvarsandel property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getAnsvarsandel() {
                            return ansvarsandel;
                        }

                        /**
                         * Sets the value of the ansvarsandel property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setAnsvarsandel(String value) {
                            this.ansvarsandel = value;
                        }

                        /**
                         * Gets the value of the fratraadt property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getFratraadt() {
                            return fratraadt;
                        }

                        /**
                         * Sets the value of the fratraadt property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setFratraadt(String value) {
                            this.fratraadt = value;
                        }

                        /**
                         * Gets the value of the fratraadtTekst property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getFratraadtTekst() {
                            return fratraadtTekst;
                        }

                        /**
                         * Sets the value of the fratraadtTekst property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setFratraadtTekst(String value) {
                            this.fratraadtTekst = value;
                        }

                        /**
                         * Gets the value of the revisorKategori property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link Integer }
                         *     
                         */
                        public Integer getRevisorKategori() {
                            return revisorKategori;
                        }

                        /**
                         * Sets the value of the revisorKategori property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link Integer }
                         *     
                         */
                        public void setRevisorKategori(Integer value) {
                            this.revisorKategori = value;
                        }

                        /**
                         * Gets the value of the revisorRkode property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link Integer }
                         *     
                         */
                        public Integer getRevisorRkode() {
                            return revisorRkode;
                        }

                        /**
                         * Sets the value of the revisorRkode property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link Integer }
                         *     
                         */
                        public void setRevisorRkode(Integer value) {
                            this.revisorRkode = value;
                        }

                        /**
                         * Gets the value of the reTekst property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getReTekst() {
                            return reTekst;
                        }

                        /**
                         * Sets the value of the reTekst property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setReTekst(String value) {
                            this.reTekst = value;
                        }

                        /**
                         * Gets the value of the rolleFritekst property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getRolleFritekst() {
                            return rolleFritekst;
                        }

                        /**
                         * Sets the value of the rolleFritekst property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setRolleFritekst(String value) {
                            this.rolleFritekst = value;
                        }

                        /**
                         * Gets the value of the beskrivelse property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getBeskrivelse() {
                            return beskrivelse;
                        }

                        /**
                         * Sets the value of the beskrivelse property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setBeskrivelse(String value) {
                            this.beskrivelse = value;
                        }

                        /**
                         * Gets the value of the statuskode property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getStatuskode() {
                            return statuskode;
                        }

                        /**
                         * Sets the value of the statuskode property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setStatuskode(String value) {
                            this.statuskode = value;
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
                         *       &amp;lt;attribute name="landkode4" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
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
                        public static class Land {

                            @XmlValue
                            protected String value;
                            @XmlAttribute(name = "landkode4", required = true)
                            protected String landkode4;

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
                             * Gets the value of the landkode4 property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getLandkode4() {
                                return landkode4;
                            }

                            /**
                             * Sets the value of the landkode4 property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setLandkode4(String value) {
                                this.landkode4 = value;
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
                         *       &amp;lt;attribute name="kode" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
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
                        public static class ValgtAv {

                            @XmlValue
                            protected String value;
                            @XmlAttribute(name = "kode", required = true)
                            protected String kode;

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
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            public String getKode() {
                                return kode;
                            }

                            /**
                             * Sets the value of the kode property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *     
                             */
                            public void setKode(String value) {
                                this.kode = value;
                            }

                        }

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
     *         &amp;lt;element name="orgnr" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
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
     *       &amp;lt;attribute name="tjeneste" use="required"&amp;gt;
     *         &amp;lt;simpleType&amp;gt;
     *           &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
     *             &amp;lt;minLength value="1"/&amp;gt;
     *             &amp;lt;maxLength value="40"/&amp;gt;
     *           &amp;lt;/restriction&amp;gt;
     *         &amp;lt;/simpleType&amp;gt;
     *       &amp;lt;/attribute&amp;gt;
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
        "hovedStatus",
        "underStatus"
    })
    public static class ResponseHeader {

        protected int orgnr;
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
         */
        public int getOrgnr() {
            return orgnr;
        }

        /**
         * Sets the value of the orgnr property.
         * 
         */
        public void setOrgnr(int value) {
            this.orgnr = value;
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
