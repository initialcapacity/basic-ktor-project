val stripeVersion: String by project

dependencies {
    implementation(project(":components:database-support"))
    implementation(project(":components:stripe-support"))

    implementation("com.stripe:stripe-java:$stripeVersion")
}
