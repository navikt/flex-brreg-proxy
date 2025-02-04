
package generated.rolleutskrift;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * &lt;p&gt;Java class for adresseType2 complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="adresseType2"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
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
 *         &amp;lt;element name="kommune" minOccurs="0"&amp;gt;
 *           &amp;lt;complexType&amp;gt;
 *             &amp;lt;simpleContent&amp;gt;
 *               &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
 *                 &amp;lt;attribute name="kommnr" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *                 &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *               &amp;lt;/extension&amp;gt;
 *             &amp;lt;/simpleContent&amp;gt;
 *           &amp;lt;/complexType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="land"&amp;gt;
 *           &amp;lt;complexType&amp;gt;
 *             &amp;lt;simpleContent&amp;gt;
 *               &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
 *                 &amp;lt;attribute name="landkode1" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *                 &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *               &amp;lt;/extension&amp;gt;
 *             &amp;lt;/simpleContent&amp;gt;
 *           &amp;lt;/complexType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *       &amp;lt;attribute name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "adresseType2", propOrder = {
    "adresse1",
    "adresse2",
    "adresse3",
    "postnr",
    "poststed",
    "kommune",
    "land"
})
public class AdresseType2 {

    protected String adresse1;
    protected String adresse2;
    protected String adresse3;
    protected String postnr;
    protected String poststed;
    protected AdresseType2 .Kommune kommune;
    @XmlElement(required = true)
    protected AdresseType2 .Land land;
    @XmlAttribute(name = "ledetekst")
    protected String ledetekst;

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
     * Gets the value of the kommune property.
     * 
     * @return
     *     possible object is
     *     {@link AdresseType2 .Kommune }
     *     
     */
    public AdresseType2 .Kommune getKommune() {
        return kommune;
    }

    /**
     * Sets the value of the kommune property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdresseType2 .Kommune }
     *     
     */
    public void setKommune(AdresseType2 .Kommune value) {
        this.kommune = value;
    }

    /**
     * Gets the value of the land property.
     * 
     * @return
     *     possible object is
     *     {@link AdresseType2 .Land }
     *     
     */
    public AdresseType2 .Land getLand() {
        return land;
    }

    /**
     * Sets the value of the land property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdresseType2 .Land }
     *     
     */
    public void setLand(AdresseType2 .Land value) {
        this.land = value;
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
     *   &amp;lt;simpleContent&amp;gt;
     *     &amp;lt;extension base="&amp;lt;http://www.w3.org/2001/XMLSchema&amp;gt;string"&amp;gt;
     *       &amp;lt;attribute name="kommnr" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
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
    public static class Kommune {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "kommnr", required = true)
        protected String kommnr;
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
         * Gets the value of the kommnr property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKommnr() {
            return kommnr;
        }

        /**
         * Sets the value of the kommnr property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKommnr(String value) {
            this.kommnr = value;
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
     *       &amp;lt;attribute name="landkode1" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
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
    public static class Land {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "landkode1", required = true)
        protected String landkode1;
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
         * Gets the value of the landkode1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLandkode1() {
            return landkode1;
        }

        /**
         * Sets the value of the landkode1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLandkode1(String value) {
            this.landkode1 = value;
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
