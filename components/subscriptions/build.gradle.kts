val postgresVersion: String by project
val stripeVersion: String by project

dependencies {
    implementation(project(":components:database-support"))
    implementation(project(":components:stripe-support"))

    implementation("com.stripe:stripe-java:$stripeVersion")

    testImplementation("org.postgresql:postgresql:$postgresVersion")
}
