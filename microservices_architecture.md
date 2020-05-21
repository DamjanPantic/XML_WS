
## Auth service
prefix=/auth

modeli = User, Admin, CarOwner(Individual, Company)\
-servis zaduzen za manipulisanje korsinicima i permisijama.

POST /signup\
signup(SignupDTO dto);\
-registracija svih tipova korisnika

POST /signin\
signin(SignInDTO dto);\
-prijvaljvivanje na osovnu email password

POST /me\
me();\
-vraca korisnika na osnovu jwt

POST /users/{user_id}/permissions\
addPermission(Permission dto);\
-dodavanje permisija korisniku na osnovu koijh ce se dalje vrsiti autorizacija

PUT  /users/{user_id}/permissions/{permission_id}\
updatePermission(Permission dto);\
-izmena permisija

DELETE  /users/{user_id}/permissions/{permission_id}\
deletePermission();\
-brisanje permisija

PUT /users/{id}\
updateUser(UserDTO dto);\
-izmena korisnika

GET /users\
getAllUsers();\
-preuzimanje svih korisnika sistema

GET /users/{id}\
getUserById();\
-preuzimanje jednog korisnka na osnovu id

DELETE /uses/{id}\
delete();\
-brisanje korisnika

## Vehicle service
prefix=/vehicles

modeli = Vehicle, PriceList, Availability\
-serivs zaduzen za CRUD operacije nad vozilima, dodavanje dostupnosti vozila  i za CRUD nad cenovnikom. Koriste ga admin i korsinici/firme koji postavljaju oglase. Admin je zaduzen za dodavanje proizvodjaca i modela vozila kako korisnici/firme koji postvljaju oglase ne mogu da postavljaju nepostojece modele vozila nego samo one koji su prethodno dodati od strane admina. Korisnik/firma koja postavlja oglas definise cenovnike za vozila(po kilometru, po danu itd.). 
Admin definise tipove cena.

POST /\
addVehicle(VehicleDTO dto);\
-dodavanje vozila

PUT /{id}\
update(VehicleDTO dto);\
-izmena postojeceg vozila

DELETE /{id}\
delete();\
-brisanje vozila

POST /feature-types\
addFeatureType(FeatureTypeDTO dto);\
-dodavanje tipa osobina npr gorivo, kubikaza, snaga itd. Dodaje fleksibilnost u slucaju da se u toku koriscenja aplikacije javi potreba za uvodjenjem neke nove osobine vozila bez potrebe izmene seme baze podataka.

POST /availabilities\
addAvailability(AvailabilityDTO dto);\
-dodavanje dostupnosti vozila, od kad do kad je vozilo slobodno i na kojoj lokaciji

PUT /availabilities/{id}\
updateAvailability(AvailabilityDTO dto);\
-izmena dostupnosti

DELETE /availabilities/{id}\
deleteAvailability();\
-brisanje dostupnosti

GET /\
getVehicles();\
-preuzimanje svih vozila iz baze

GET /{id}\
getVehicleById();\
-preuzimanje vozila na osnovu id

POST /prices/price-types\
addPriceType(PriceTypeDTO dto);\
-dodavnje tipa cene, vrsi admin

GET {id}/prices/\
getVehiclePrices();\
-preuzmenje cenovnika nekog vozila

POST {id}/prices/{id_price_type}\
addPriceEntry(PriceEntryDTO dto);\
-dodavanje stavke u cenovnik nekog vozila za neki tip cene.

PUT {vehicle_id}/prices/{price_id}\
updatePriceEntry(PriceEntryDTO dto);\
-izmena stavke u cenovniku nekog vozila

DELETE {vehicle_id}/prices/{price_id}\
deletePriceEntry();\
-brisanje stavke u cenovniku nekog vozika

POST /manufacturer\
addManufacturer(ManufacturerDTO dto)\ 
-dodavanje prozizvodjaca vozila(marke), ideja je da admin dodaje prozivodjace kako korisnik/firma koja objavljuje oglas moze da izabere samo validne proizvodjace.

POST /manufacturer/{manufacturer_id}/model
addModel(ModelDTO dto);
-dodavanje modela vozila za nekog postojeceg proizvodjaca

## Search Service
prefix=/search

modeli = Vehicle, PriceList, Availability\
-servis zaduzen za pretragu i naprednu pretragu vozila. 

GET /{}\
search(SearchParamDTO dto);\
-pretraga vozila na osnovu prametara u dto

GET /advance\
advanceSearch(AdvanceSearchParamDTO dto);\
-napredna pretraga vozila na osnovu parametara u dto

## RentalService
prefix=/rentals

modeli = Vehicle\
-servis zaduzen za inzajmnjivanje

POST /requests\
createNewRentalRequest(RentaReqDTO dto);\
-kreiranje novog zahteva za iznajmljivanje

POST /requests/{request_id}/item\
addItemToRentalRequest(ItemDTO dto);\
-dodavanje vozila u korpu 

GET /requests\
getAllRequests();\
-preuzmenje svih zahteva

GET /requests/{request_id}\
getRequestById();\
-preuzimanje zahteva za iznajmljivanje na osnovu id

POST /requests/{request_id}/submit\
submitRequest();\
-submitovanje zahteva

## Recension service
prefix=/recensions

modeli=Comment, Like\
-servis zaduzen za komentare, lajkove/dislajkove

POST /comments\
addNewComment(CommentDTO dto);\
-dodavanje komentara

PUT /comments/{id}\
updateComment(CommentDTO dto);\
-izmena komentara

DELETE /comments/{id}\
deleteComment();\
-brisanje komentara

POST /likes\
like(LikeDTO dto);\
-ostavljanje lajka

POST /dislikes\
dislike(DislikeDTO);\
-ostavljanje dislajka

## Message service
prefix=/messages

model = Message\
-servis zaduzen za slanje poruka

POST /\
sendMessage(MessageDTO dto);\
-slanje poruke

GET /\
getAllMessages();\
-preuzimanje svih poruka konkretnog korisnika(samo ulogovani korisnik moze dobiti svoje poruke)

GET /{participant_id}\
getAllMessagesByParticipant();\
-preuzmenje poruke na osnovu id sagovornika

## Email service
prefix=/emails

model=Email

POST /\
sendEmail(EmailDTO dto);\
-slanje email

GET /\
getAllEmails();\
-preuzmenje mejlova korisnika

GET /{paritcipant_id}\
getAllEmailsByParticipant();\
-preuzimanje mejlova na osnovu id sagovornika

## Location service
prefix=/locations

model=LocationEntry\
-servis zaduzen za pracenje vozila, uredjaj iz vozila salje podatke na ovaj servis.

POST /\
addLocationEntry(LocationEntryDTO dto);\
-dodavanje trenutne lokacije koju salje uredjaj, dodaje se lat i lng

GET /vehicles/{vehicle_id}\
getLocationsByVehicle()\
-preuzmenje svih pozicija vozila na osnovu id vozila 
