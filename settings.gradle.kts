rootProject.name = "basic-ktor-project"

include(
    "applications:report-app",
    "applications:report-worker",

    "components:database-support",
    "components:stripe-support",
    "components:subscriptions",
)