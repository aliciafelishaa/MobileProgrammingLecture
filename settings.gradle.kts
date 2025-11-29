pluginManagement {
    repositories {
        maven {
            url = uri("http://proxy.apps.slc.net:23222/repository/maven-public/")
            isAllowInsecureProtocol = true
        }
        maven {
            url = uri("http://proxy.apps.slc.net:23222/repository/google/")
            isAllowInsecureProtocol = true
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        maven {
            url = uri("http://proxy.apps.slc.net:23222/repository/maven-central/")
            isAllowInsecureProtocol = true
        }
        maven {
            url = uri("http://proxy.apps.slc.net:23222/repository/gradle-plugin-portal/")
            isAllowInsecureProtocol = true
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven {
            url = uri("http://proxy.apps.slc.net:23222/repository/maven-public/")
            isAllowInsecureProtocol = true
        }
        maven {
            url = uri("http://proxy.apps.slc.net:23222/repository/google/")
            isAllowInsecureProtocol = true
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        maven {
            url = uri("http://proxy.apps.slc.net:23222/repository/maven-central/")
            isAllowInsecureProtocol = true
        }
    }
}




rootProject.name = "Session11"
include(":app")
 
