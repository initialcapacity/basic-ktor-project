val postgresVersion: String by project
val hikariVersion: String by project

dependencies {
    implementation("org.postgresql:postgresql:$postgresVersion")
    implementation ("com.zaxxer:HikariCP:$hikariVersion")
}
