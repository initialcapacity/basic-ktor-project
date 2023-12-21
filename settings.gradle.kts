rootProject.name = "basic-ktor-project"

include(
    "applications:webapp",
    "applications:worker",

    "components:database-support",
    "components:stripe-support",
    "components:subscriptions",
    "components:web",
)