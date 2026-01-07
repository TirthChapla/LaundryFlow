# Laundry Management System

A modern, full-featured laundry management system built with React, Vite, and plain CSS.

## Features

### Authentication
- **Login & Register** for both Customer and Shop Owner roles
- Form validation with error handling
- Persistent sessions using localStorage
- Beautiful gradient-based UI with animations

### Customer Features

#### Dashboard
- Overview of total, active, and completed orders
- Recent orders list with status tracking
- Real-time notifications for order updates
- Profile information display

#### Create Order (Complete Workflow)
**Step 1: Select City & Shop**
- Default city selection from registration
- Option to change city
- Display laundry shops filtered by city
- Search shops by name
- View shop ratings and base prices

**Step 2: Select Items & Services**
- Multiple item categories:
  - Shirts (Formal Shirt, T-Shirt)
  - Pants & Bottoms (Pant, Jeans)
  - Traditional Wear (Sari, Kurti)
  - Women's Wear (Crop Top, Dress)
- **Image Upload/Capture** for each item:
  - Take photo with camera
  - Upload from gallery
  - Image validation (simulated Python model)
  - Background removal and processing (simulated)
  - Image compression (simulated)
  - Cloudinary upload (simulated)
- **Service Selection** per item:
  - Washing (included)
  - Ironing (+₹20)
  - Dry Cleaning (+₹50)
  - Stain Removal (+₹30)
- Real-time price calculation
- Remove items from cart
- Split view: catalog on left, cart on right

**Step 3: Checkout**
- Address confirmation (pre-filled from registration)
- Phone number confirmation
- Special instructions field
- Order summary with all items
- Item-wise pricing breakdown
- Total amount calculation
- Place order button

#### Order Tracking
- View all orders
- Track order status
- Receive notifications

### Design Features
- Modern SaaS-style UI
- Gradient backgrounds and buttons
- Smooth transitions and hover effects
- Large border radius (16-24px)
- Intentional spacing and typography
- Responsive design for mobile and desktop
- No utility frameworks (plain CSS only)
- CSS variables for consistent theming

## Tech Stack

- **Frontend**: React 18.3
- **Build Tool**: Vite 5.1
- **Routing**: React Router DOM 6.22
- **Icons**: Lucide React
- **Styling**: Plain CSS with CSS Variables
- **State Management**: React Hooks (useState, useEffect)

## Installation & Setup

1. **Install Dependencies**
   ```bash
   npm install
   ```

2. **Run Development Server**
   ```bash
   npm run dev
   ```
   The app will be available at `http://localhost:3000` (or another port if 3000 is in use)

3. **Build for Production**
   ```bash
   npm run build
   ```

4. **Preview Production Build**
   ```bash
   npm run preview
   ```

## Usage

### For Customers

1. **Register/Login** as a Customer
2. **Create Order**:
   - Select your city (defaults to registration city)
   - Browse and select a laundry shop
   - Choose items from various categories
   - Upload/capture image for each item
   - Select services (washing, ironing, dry cleaning, stain removal)
   - Review your cart with real-time pricing
   - Proceed to checkout
   - Confirm address and phone number
   - Add special instructions (optional)
   - Review order summary
   - Place order
3. **Track Orders** from dashboard
4. **Receive Notifications** for order updates

### For Shop Owners

1. **Register/Login** as a Shop Owner
2. Dashboard (coming soon)
3. Receive order notifications
4. Manage orders

## Future Enhancements

### Backend Integration (Java Spring Boot)
- RESTful API for all operations
- Database integration (MySQL/PostgreSQL)
- JWT authentication
- Real-time notifications
- Image upload to Cloudinary
- Python model integration for image validation
- Background removal service
- Order management system
- Payment gateway integration

### Additional Features
- Order editing before confirmation
- Real-time order tracking with status updates
- Push notifications
- Payment integration
- Order history and analytics
- Review and rating system
- Multiple delivery address management
- Promo codes and discounts
- Shop owner dashboard features:
  - Order management
  - Price management
  - Service management
  - Analytics and reports

## Design Philosophy

This project follows a **production-ready design approach**:

- ❌ No generic layouts or tutorial-style UI
- ✅ Strong visual hierarchy with intentional typography
- ✅ Grid-based layouts with deliberate alignment
- ✅ Subtle shadows, gradients, and large rounded corners
- ✅ Tasteful hover states and smooth transitions
- ✅ Modern SaaS product aesthetic
- ✅ Polished, thoughtfully composed interfaces

## CSS Architecture

- **CSS Variables** for colors, spacing, shadows, and radii
- **Semantic class naming** (not utility classes)
- **Separate concerns**: layout styles, component styles, animations
- **CSS Grid** for page layouts
- **Flexbox** where appropriate
- **Responsive design** with mobile-first approach

## Browser Support

- Chrome (latest)
- Firefox (latest)
- Safari (latest)
- Edge (latest)

## License

This project is for educational and demonstration purposes.

## Contact

For questions or support, please contact the development team.
