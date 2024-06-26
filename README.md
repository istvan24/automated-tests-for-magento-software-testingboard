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
- Use at least one static helpers and one DB helpers connection (you can get login credentials from DB and register from one 
static file with one of extension like: json, xml or excel/csv
- Have at least 8 tests with different scenarios ( login, register, add to cart, filtering, etc)
- Have at least 2 running suites using TestNG xml suites like smoke and regression
- Use test reporting - e-mailable reports Use configuration file for static config like: hostname, DB connection 
information, default browser, etc
- Support different browsers that can be selected at runtime of tests

## Test Plan:
### Test case nr 1: Test the create new account functionality
1. Go to login page `https://magento.softwaretestingboard.com/customer/account/create/`
2. Fill required fields.
3. Click Create an account button.

### Test case nr 2: Test the warning messages from create new account page
1. Go to login page `https://magento.softwaretestingboard.com/customer/account/create/`
2. Leave empty the required fields.
3. Click Create an account button.
4. Check the warning messages below the mandatory fields.

### Test case nr 3: Login into an existent account
1. Go to login page 'https://magento.softwaretestingboard.com/customer/account/login/'
2. Fill required fields with an existent users credentials.
3. Click on Sign in button.
4. Check the "Welcome + username!" text after the success login.

### Test case nr 4: Check the warning messages from login page
1. Go to login page 'https://magento.softwaretestingboard.com/customer/account/login/'
2. Leave empty the warning fields.
3. Click on Sign in button.
4. Check the warning messages below the mandatory fields.

### Test case nr 5: Test the add products to Wishlist functionality
1. Login with valid credentials.
2. Go to a page with clothes.
3. Go to any product detail page and click Add to Wishlist button.
Expected result: Product was added to Wishlist

### Tets case nr 5: Test the add products to cart functionality
1. Login
2. Go to a page with clothes
3. Add 3 different products to cart
4. Go to shopping cart
Expected result: Products were added to cart