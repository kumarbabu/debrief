/*
 *    Debrief - the Open Source Maritime Analysis Application
 *    http://debrief.info
 *
 *    (C) 2000-2014, PlanetMayo Ltd
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the Eclipse Public License v1.0
 *    (http://www.eclipse.org/legal/epl-v10.html)
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 */
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.30 at 10:32:43 PM EDT 
//


package org.mwc.debrief.core.gpx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for plotType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="plotType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="session" type="{org.mwc.debrief.core}sessionType"/>
 *         &lt;element name="details" type="{org.mwc.debrief.core}detailsType" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="Created" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PlotId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "plotType", propOrder = {

})
public class PlotType {

    @XmlElement(required = true)
    protected SessionType session;
    protected DetailsType details;
    @XmlAttribute(name = "Created", required = true)
    protected String created;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "PlotId")
    protected String plotId;

    /**
     * Gets the value of the session property.
     * 
     * @return
     *     possible object is
     *     {@link SessionType }
     *     
     */
    public SessionType getSession() {
        return session;
    }

    /**
     * Sets the value of the session property.
     * 
     * @param value
     *     allowed object is
     *     {@link SessionType }
     *     
     */
    public void setSession(final SessionType value) {
        this.session = value;
    }

    /**
     * Gets the value of the details property.
     * 
     * @return
     *     possible object is
     *     {@link DetailsType }
     *     
     */
    public DetailsType getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     * 
     * @param value
     *     allowed object is
     *     {@link DetailsType }
     *     
     */
    public void setDetails(final DetailsType value) {
        this.details = value;
    }

    /**
     * Gets the value of the created property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreated() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreated(final String value) {
        this.created = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(final String value) {
        this.name = value;
    }

    /**
     * Gets the value of the plotId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlotId() {
        return plotId;
    }

    /**
     * Sets the value of the plotId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlotId(final String value) {
        this.plotId = value;
    }

}
