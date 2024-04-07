<h1>Inventory_Management_System</h1>
<br><br>
<b>Web Services Assignment one, Identify 4 core resources to develop an inventory management system</b>
<br><br>
<i>I will show the steps i made in this part sequentially:</i>
<br><br>
<li>I started with identifing the four inventory Entities and their attributes
<br><br>
<li>First Entity i need in my Inventory Management System is the <b>Inventory</b>, which has Four Attributes: InventoryID, InventoryName, InventoryLocation, and InventoryOwnerName</li>
<br>
<li>The second entity is the core and primary resource in any inventory management system: <b>the Item.</b> It comprises four attributes: ItemID, ItemName, ItemBarcode, and ItemPrice</li>
<br>
<li>Third Entity is: Provider, which has 5 attributes: ProviderID, ProviderName, ProviderPhoneNumber, ProviderLocation, and ProviderEmail</li>
<br>
<li>Fourth and Last Entity is: Consumer, which has 5 attributes: ConsumerID, ConsumerName, ConsumerBDate, ConsumerLocation, and ConsumerEmail</li>
<br>
<li>finally defined relations between entities and will be Showed in The ER Diagram Below</li> 
<br>
<h2>The Figure below represents th ER diagram for my Inventory management System</h2>

![image](https://github.com/mohammad-obeid-1200644/Inventory_Management_System/assets/132138605/b50d4905-8a81-4ea7-8f27-b28023cd102c)
<br><br>
As shown in the figure, i have four resources, first resource is <b>Inventory</b> and it represents the warehouse that stores items.
second resource is the core resource in this system, which is the <b>Item</b> and it represents the products or peices stored in some Inventory.
third resource is the <b>provieder</b>, provider is the character that supplies items and products to be stored in the Inventory.
fourth and final resource is <b>consumer</b>, consumer is the character that consumes items.
<br>
<h2>How to run this application?!</h2>
As i showd before in the ER diagram, i have four entities, all of them have infinity relation except inventory it has 1, that means the first entity must have real data is Inventory, that allows me to add items data and put it in some inventory, after i add real data for Inventory and Item i can add item providers data, and finally consumers data can be added.
<br>
I defiend the http methods im gonna use for each service "i will show and specify them below in a detailed tables", im gonna use a set of methods for each service such as get entity by id, get list of entities, post new entity, update entity by id.
These Methods were specified and designed in this Swagger link (https://app.swaggerhub.com/apis/1200644_1/InventoryManagemntSystem/Version1), plus to the below Tables that also descripes HTTP methods used in my API
<br>
<b></b>The below File contains 4 Tables the descripes the four Resources i Identified Previously, Http Methods i useed for each Entity, Response and Request sample of each Method, status Codes, and End Points of each Method</b>
<br>
[WebServicesAssOneDocumentation.docx](https://github.com/mohammad-obeid-1200644/Inventory_Management_System/files/14898356/WebServicesAssOneDocumentation.docx)

<br>
<h2>Future Work</h2>
<br>
<p>In the Future Tasks For this Assignment i'm gonna define more HTTP Methods that will be helpful in this System such as:</p>
<li>Delete Some Item from Provider</li>
<br>
<li>Add Items For Provider</li>
<br>
<li>Update Item Information for some Provider</li>
<br>
<P>This Work was done By 1200644-Mohammad Obeid</P>
<P>Instructor: Dr. Mohammad Kharmah</P>
