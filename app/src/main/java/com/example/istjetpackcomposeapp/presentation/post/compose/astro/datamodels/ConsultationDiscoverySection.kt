package com.example.istjetpackcomposeapp.presentation.post.compose.astro.datamodels

import android.os.Parcelable
import com.example.istjetpackcomposeapp.R

/**
 * PUBLIC_CONSULTATION
 * **/



open class ConsultationDiscoverySection


/**
 * PUBLIC_CONSULTATION
 * **/

data class PublicConsultationSection(
    val headerIconUrl: String,
    val sectionType: String,
    val entity: String,
    val headerName: String,
    val showSeeMoreButton: Boolean,
    val offset: Int,
    val publicConsultationList: List<PublicConsultationDiscoveryData>
) : ConsultationDiscoverySection()

data class PublicConsultationDiscoveryData(
    val name: String,
    val imageIconUrl: String,
    val onlineCount: String,
    val entityId: String,
    val entity: String,
    val category: String,
    val backgroundColor: String,
    val strokeColor: List<String>,
    val secondLineTextColor: String,
    val frameUrl: String,
    val statusUrl: String
) : ConsultationDiscoverySection()



/**
 * PRIVATE_CONSULTATION
 * **/

data class PrivateConsultationSection(
    val headerIconUrl: Int = R.drawable.start_icon,
    val sectionType: String= "",
    val entity: String= "",
    val headerName: String = "Top Private Consultation",
    val showSeeMoreButton: Boolean = true,
    val offset: Int= 0,
    val showThisHeaderSection: Boolean = (offset == 0),
    val privateConsultationList: List<PrivateConsultationDiscoveryData> = listOf(
        PrivateConsultationDiscoveryData(),
        PrivateConsultationDiscoveryData(),
        PrivateConsultationDiscoveryData(),
        PrivateConsultationDiscoveryData(),
        PrivateConsultationDiscoveryData(),
        PrivateConsultationDiscoveryData(),
        PrivateConsultationDiscoveryData(),
        PrivateConsultationDiscoveryData(),
        PrivateConsultationDiscoveryData(),
        PrivateConsultationDiscoveryData(),
        PrivateConsultationDiscoveryData(),
    )
) : ConsultationDiscoverySection()


data class PrivateConsultationDiscoveryData(
    val name: String = "Astro Guru",
    val imageIconUrl: Int = R.drawable.insta_user_profile,
    val expertiseText: String = "Love, Marriage, Career, Numerology",
    val entityId: String = "",
    val entity: String = "",
    val category: String = "",
    val limit: Long = 0,
    val offset: Int = 0,
    val criteriaIcon: String = "",
    val rateAmount: Int = 1,
    val rateTextDurationPlaceHolder: String = "",
    val showRateSeparator: Boolean = true,
    val experienceText: String= "Exp: 3yrs",
    val isOnline: Boolean = true,
    val status: String= "",
    val buttonText: String= "",
) : ConsultationDiscoverySection()