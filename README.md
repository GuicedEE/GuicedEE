# GuicedEE-Projects

---

## Version 2
Version 2 brings performance optimizations and library replacements with their modularized counterparts, 
assisting in the usage, and migration of projects.

The base Java version is 17, 

- All libraries have been updated to their latest versions 
- Builders are moved from TeamCity to GitHub Actions
- Local builders are located in the 
- Jakarta Libraries replaced with their maven repositories
- Most Apache Commons libraries replaced, a few still are required to be repackaged for modularization
- Hibernate has been updated to 6.4
- The hibernate enhancer and metadata generator can now be run under the original maven co-ordinates 

The projects have the following updaters

- GuicedInjection has been split from the domain representations, which are now visible from the services package.
    Representations using field reflection will be required to open the packages to the provider as per norm
- Service Providers are now in their own library and module ```com.guicedee.client```
- Wildfly configuration reporter has been removed
- 

