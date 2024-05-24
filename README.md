## Technology Stack:
1. Programming language - `Java`
2. Build and project management tool - `Maven`
3. Testing framework - `TestNG`
4. Automation framework - `Selenium WebDriver`

## Tasks:
Please create a new automation project for a ecommerce site, using the next guide: - Use ecommerce site that has login. 
registration and shopping capabilities ( shopping bag, filters, Wishlist and checkout)

- Use as standard coding language java and maven as dependency tool
- Use Selenium and Test NG as testing frameworks
- Create automation framework structure that respect the presented best practice guidelines (Page Objects, Utils, Tests,
etc)
- Use static helpers and one DB helpers connection (you can get login credentials from DB and register from static files
like: json, xml, xlsx, csv
- Have at least 8 tests with different scenarios ( login, register, add to cart, filtering, etc)
- Have at least 2 running suites using TestNG xml suites like smoke and regression
- Use test reporting - e-mailable reports Use configuration file for static config like: hostname, DB connection 
information, default browser, etc
- Support different browsers that can be selected at runtime of tests

## Test Plan:
### Test case nr 1: Test the create new account functionality: CreateNewAccountTest
1. Go to login page `https://magento.softwaretestingboard.com/customer/account/create/`
2. Fill required fields.
3. Click Create an account button.
   Expected result: A new user account is successfully created.

### Test case nr 2: Verify the warning validation messages on registration page: VerifyWarningMessagesOnRegisterPage
1. Go to login page `https://magento.softwaretestingboard.com/customer/account/create/`
2. Click Create an account button.
3. Leave empty all the mandatory fields and click on the "Create an account" button. 
   Expected result: All the validation messages are shown.

### Test case nr 3: Login into an existent account: LoginWithValidCredentialsTests
1. Go to login page 'https://magento.softwaretestingboard.com/customer/account/login/'
2. Fill required fields with an existent users credentials.
3. Click on Sign in button.
4. Check the "Welcome + username!" text after the success login.
   Expected result: The welcome message appears after the valid login.

### Test case nr 4: Check the warning messages from login page: LoginWithInvalidUsernameTest
1. Go to login page 'https://magento.softwaretestingboard.com/customer/account/login/'
2. Leave empty the warning fields.
3. Click on Sign in button.
4. Check the warning messages below the mandatory fields.
   Expected result: The warning messages appears correct.

### Test case nr 5: Test the add products to Wishlist functionality: AddRandomProductToWishlistTest
1. Login with valid credentials.
2. Go to a page with clothes.
3. Go to any product detail page and click Add to Wishlist button.
   Expected result: Product was added to Wishlist.

### Test case nr 6: Test the add products to cart functionality: AddProductFromWishListToCartTest
1. Login with valid credentials.
2. Go to a page with clothes.
3. Add 3 different products to cart.
4. Go to shopping cart.
   Expected result: Products were added to cart.

### Test case nr 7: Test if given number of products are successfully added to cart: ProductAddedSuccesfullyToCartTest
1. Login with valid credentials.
2. Go to a category page, save the available products number.
3. Go to a category and select other products, add them to the cart.
4. Navigate back to the cart and check if the final products quantity is correctly updated with.
   Expected result: The final quantity is correctly calculated. 

### Test case nr 8: Test the add new address on the My account page: AddNewAddressTest
1. Login with valid credentials.
2. Go to My account page.
3. Add a new address using the javafaker library. 
4. Check if the message-success appears.
   Expected result: New address is succefully added.

### Test case nr 9: Test the Sizefilter on a category page: VerifySizeFilterOnCategoryPageTest
1. Login with valid credentials.
2. Go to a category page.
3. Select the XL size.
4. Check if the XL size appears for all the filtered products.
   Expected result: XL size appears for all the products.

### Test case nr 10: Test the size and color warning messages for a product on a product page: VerifyRequiredFieldMessageOnProductPageTest
1. Login with valid credentials.
2. Go to a product page.
3. Click add to cart button.
4. Check the 2 validation messages: size and color for the product.
   Expected result: The mandatory warning messages appears.