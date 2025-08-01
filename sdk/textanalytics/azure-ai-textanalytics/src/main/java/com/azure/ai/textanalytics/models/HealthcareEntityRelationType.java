// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Type of relation. Examples include: `DosageOfMedication` or 'FrequencyOfMedication', etc.
 */
public final class HealthcareEntityRelationType extends ExpandableStringEnum<HealthcareEntityRelationType> {
    /**
     * Static value Abbreviation for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType ABBREVIATION = fromString("Abbreviation");

    /**
     * Static value BodySiteOfCondition for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType BODY_SITE_OF_CONDITION = fromString("BodySiteOfCondition");

    /**
     * Static value BodySiteOfTreatment for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType BODY_SITE_OF_TREATMENT = fromString("BodySiteOfTreatment");

    /**
     * Static value CourseOfCondition for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType COURSE_OF_CONDITION = fromString("CourseOfCondition");

    /**
     * Static value CourseOfExamination for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType COURSE_OF_EXAMINATION = fromString("CourseOfExamination");

    /**
     * Static value CourseOfMedication for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType COURSE_OF_MEDICATION = fromString("CourseOfMedication");

    /**
     * Static value CourseOfTreatment for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType COURSE_OF_TREATMENT = fromString("CourseOfTreatment");

    /**
     * Static value DirectionOfBodyStructure for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType DIRECTION_OF_BODY_STRUCTURE
        = fromString("DirectionOfBodyStructure");

    /**
     * Static value DirectionOfCondition for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType DIRECTION_OF_CONDITION = fromString("DirectionOfCondition");

    /**
     * Static value DirectionOfExamination for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType DIRECTION_OF_EXAMINATION = fromString("DirectionOfExamination");

    /**
     * Static value DirectionOfTreatment for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType DIRECTION_OF_TREATMENT = fromString("DirectionOfTreatment");

    /**
     * Static value DosageOfMedication for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType DOSAGE_OF_MEDICATION = fromString("DosageOfMedication");

    /**
     * Static value ExaminationFindsCondition for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType EXAMINATION_FINDS_CONDITION
        = fromString("ExaminationFindsCondition");

    /**
     * Static value ExpressionOfGene for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType EXPRESSION_OF_GENE = fromString("ExpressionOfGene");

    /**
     * Static value ExpressionOfVariant for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType EXPRESSION_OF_VARIANT = fromString("ExpressionOfVariant");

    /**
     * Static value FormOfMedication for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType FORM_OF_MEDICATION = fromString("FormOfMedication");

    /**
     * Static value FrequencyOfCondition for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType FREQUENCY_OF_CONDITION = fromString("FrequencyOfCondition");

    /**
     * Static value FrequencyOfMedication for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType FREQUENCY_OF_MEDICATION = fromString("FrequencyOfMedication");

    /**
     * Static value FrequencyOfTreatment for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType FREQUENCY_OF_TREATMENT = fromString("FrequencyOfTreatment");

    /**
     * Static value MutationTypeOfGene for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType MUTATION_TYPE_OF_GENE = fromString("MutationTypeOfGene");

    /**
     * Static value MutationTypeOfVariant for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType MUTATION_TYPE_OF_VARIANT = fromString("MutationTypeOfVariant");

    /**
     * Static value QualifierOfCondition for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType QUALIFIER_OF_CONDITION = fromString("QualifierOfCondition");

    /**
     * Static value RelationOfExamination for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType RELATION_OF_EXAMINATION = fromString("RelationOfExamination");

    /**
     * Static value RouteOfMedication for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType ROUTE_OF_MEDICATION = fromString("RouteOfMedication");

    /**
     * Static value ScaleOfCondition for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType SCALE_OF_CONDITION = fromString("ScaleOfCondition");

    /**
     * Static value TimeOfCondition for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType TIME_OF_CONDITION = fromString("TimeOfCondition");

    /**
     * Static value TimeOfEvent for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType TIME_OF_EVENT = fromString("TimeOfEvent");

    /**
     * Static value TimeOfExamination for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType TIME_OF_EXAMINATION = fromString("TimeOfExamination");

    /**
     * Static value TimeOfMedication for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType TIME_OF_MEDICATION = fromString("TimeOfMedication");

    /**
     * Static value TimeOfTreatment for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType TIME_OF_TREATMENT = fromString("TimeOfTreatment");

    /**
     * Static value UnitOfCondition for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType UNIT_OF_CONDITION = fromString("UnitOfCondition");

    /**
     * Static value UnitOfExamination for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType UNIT_OF_EXAMINATION = fromString("UnitOfExamination");

    /**
     * Static value ValueOfCondition for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType VALUE_OF_CONDITION = fromString("ValueOfCondition");

    /**
     * Static value ValueOfExamination for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType VALUE_OF_EXAMINATION = fromString("ValueOfExamination");

    /**
     * Static value VariantOfGene for HealthcareEntityRelationType.
     */
    @Generated
    public static final HealthcareEntityRelationType VARIANT_OF_GENE = fromString("VariantOfGene");

    /**
     * Creates a new instance of HealthcareEntityRelationType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public HealthcareEntityRelationType() {
    }

    /**
     * Creates or finds a HealthcareEntityRelationType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding HealthcareEntityRelationType.
     */
    @Generated
    public static HealthcareEntityRelationType fromString(String name) {
        return fromString(name, HealthcareEntityRelationType.class);
    }

    /**
     * Gets known HealthcareEntityRelationType values.
     * 
     * @return known HealthcareEntityRelationType values.
     */
    @Generated
    public static Collection<HealthcareEntityRelationType> values() {
        return values(HealthcareEntityRelationType.class);
    }
}
