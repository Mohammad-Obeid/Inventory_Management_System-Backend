# Inventory_Management_System
Web Services Assignment one, Identify 4 core resources to develop an inventory management system


I will show the steps i made in this part sequencelly.
I started with identifing the four inventory resources, which are Inventory, Item, Provider, and consumer, then i defined the attributes for each resource, and finally defined relations between entities. 


![image](https://github.com/mohammad-obeid-1200644/Inventory_Management_System/assets/132138605/b50d4905-8a81-4ea7-8f27-b28023cd102c)


As shown in the figure, i have four resources, first resource is Inventory and it represents the warehouse that stores items.
second resource is the core resource in this system, which is the Item and it represents the products or peices stored in some Inventory.
third resource is the provieder, provider is the character that supplies items and products to be stored in the Inventory.
fourth and final resource is consumer, consumer is the character that consumes items.


How to run this application?
As i showd before in the ER diagram, i have four entities, all of them have infinity relation except inventory it has 1, that means the first entity must have real data is Inventory, that allows me to add items data and put it in some inventory, after i add real data for Inventory and Item i can add item providers data, and finally consumers data can be added.


I defiend the http methods im gonna use for each service "i will show and specify them below in a detailed tables", im gonna use a set of methods for each service such as get entity by id, get list of entities, post new entity, update entity by id.
These Methods were specified and designed in this Swagger link https://app.swaggerhub.com/apis/1200644_1/InventoryManagemntSystem/3.1.0, plus to the below Tables that also descripes HTTP methods used in my API

**The below File contains 4 Tables the descripes the four Resources i Identified Previously, Http Methods i useed for each Entity, Response and Request sample of each Method, status Codes, and End Points of each Method**

[WebServicesAssOneDocumentation.docx](https://github.com/mohammad-obeid-1200644/Inventory_Management_System/files/14876926/WebServicesAssOneDocumentation.docx)



