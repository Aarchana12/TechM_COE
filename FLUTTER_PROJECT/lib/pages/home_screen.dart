import 'package:flutter/material.dart';
import 'package:fixitnow/pages/booking_screen.dart';
import 'package:fixitnow/pages/profile_screen.dart';
import 'package:fixitnow/pages/service_list_screen.dart';
import 'package:fixitnow/pages/about_screen.dart';
import 'package:fixitnow/pages/language_screen.dart';
import 'package:fixitnow/localization/app_localization.dart';

class HomeScreen extends StatefulWidget {
  final Function(Locale) setLocale;

  HomeScreen({required this.setLocale});

  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  int _selectedIndex = 0;

  final List<Widget> _screens = [
    ServiceListScreen(),
    BookingScreen(),
    ProfileScreen(),
  ];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          AppLocalization.of(context)!.translate('fixitnow'),
          style: TextStyle(fontWeight: FontWeight.bold),
        ),
        backgroundColor: Colors.blueAccent,
        elevation: 0,
        actions: [
          IconButton(
            icon: Icon(Icons.language),
            onPressed: () {
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder:
                      (context) => LanguageScreen(setLocale: widget.setLocale),
                ),
              );
            },
          ),
          IconButton(
            icon: Icon(Icons.person),
            onPressed: () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => ProfileScreen()),
              );
            },
          ),
        ],
      ),
      drawer: _buildDrawer(context),
      body: _selectedIndex == 0 ? _buildHomePage() : _screens[_selectedIndex],
      bottomNavigationBar: BottomNavigationBar(
        items: <BottomNavigationBarItem>[
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: AppLocalization.of(context)!.translate('home'),
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.calendar_today),
            label: AppLocalization.of(context)!.translate('bookings'),
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.person),
            label: AppLocalization.of(context)!.translate('profile'),
          ),
        ],
        currentIndex: _selectedIndex,
        selectedItemColor: Colors.blueAccent,
        onTap: _onItemTapped,
      ),
    );
  }

  Widget _buildDrawer(BuildContext context) {
    return Drawer(
      child: ListView(
        padding: EdgeInsets.zero,
        children: [
          DrawerHeader(
            decoration: BoxDecoration(color: Colors.blueAccent),
            child: Text(
              AppLocalization.of(context)!.translate('menu'),
              style: TextStyle(color: Colors.white, fontSize: 24),
            ),
          ),
          ListTile(
            leading: Icon(Icons.home),
            title: Text(AppLocalization.of(context)!.translate('home')),
            onTap: () => Navigator.pop(context),
          ),
          ListTile(
            leading: Icon(Icons.build),
            title: Text(AppLocalization.of(context)!.translate('services')),
            onTap: () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => ServiceListScreen()),
              );
            },
          ),
          ListTile(
            leading: Icon(Icons.info),
            title: Text(AppLocalization.of(context)!.translate('about')),
            onTap: () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => AboutScreen()),
              );
            },
          ),
        ],
      ),
    );
  }

  Widget _buildHomePage() {
    return SingleChildScrollView(
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Padding(
            padding: EdgeInsets.all(16.0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  AppLocalization.of(context)!.translate('fixitnow'),
                  style: TextStyle(
                    fontSize: 32,
                    fontWeight: FontWeight.bold,
                    color: Colors.blueAccent,
                  ),
                ),
                SizedBox(height: 5),
                Text(
                  AppLocalization.of(context)!.translate('home_subtitle'),
                  style: TextStyle(fontSize: 16, color: Colors.grey[700]),
                ),
              ],
            ),
          ),
          _buildHeroSection(),
          _buildBookingSection(),
        ],
      ),
    );
  }

  Widget _buildHeroSection() {
    return Container(
      margin: EdgeInsets.all(16.0),
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(15),
        color: Colors.blueAccent,
      ),
      padding: EdgeInsets.all(20),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(
            AppLocalization.of(context)!.translate('explore_services'),
            style: TextStyle(
              fontSize: 24,
              fontWeight: FontWeight.bold,
              color: Colors.white,
            ),
          ),
          SizedBox(height: 10),
          Text(
            AppLocalization.of(context)!.translate('service_description'),
            style: TextStyle(fontSize: 16, color: Colors.white70),
          ),
          SizedBox(height: 15),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              _buildServiceCard(
                title: AppLocalization.of(context)!.translate('plumber'),
                imageUrl:
                    "https://static.vecteezy.com/system/resources/previews/000/472/509/original/vector-plumber-service-design-concept.jpg",
              ),
              _buildServiceCard(
                title: AppLocalization.of(context)!.translate('electrician'),
                imageUrl:
                    "https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX35744323.jpg",
              ),
            ],
          ),
          SizedBox(height: 15),
          ElevatedButton(
            onPressed: () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => ServiceListScreen()),
              );
            },
            child: Text(
              AppLocalization.of(context)!.translate('browse_services'),
            ),
            style: ElevatedButton.styleFrom(
              backgroundColor: Colors.white,
              foregroundColor: Colors.blueAccent,
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildBookingSection() {
    return Container(
      margin: EdgeInsets.all(16.0),
      padding: EdgeInsets.all(20),
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(15),
        color: Colors.orangeAccent,
      ),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(
            AppLocalization.of(context)!.translate('need_service'),
            style: TextStyle(
              fontSize: 22,
              fontWeight: FontWeight.bold,
              color: Colors.white,
            ),
          ),
          SizedBox(height: 10),
          Text(
            AppLocalization.of(
              context,
            )!.translate('service_booking_description'),
            style: TextStyle(fontSize: 16, color: Colors.white70),
          ),
          SizedBox(height: 15),
          ElevatedButton(
            onPressed: () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => BookingScreen()),
              );
            },
            child: Text(AppLocalization.of(context)!.translate('book_now')),
            style: ElevatedButton.styleFrom(
              backgroundColor: Colors.white,
              foregroundColor: Colors.orangeAccent,
            ),
          ),
        ],
      ),
    );
  }

  Widget _buildServiceCard({required String title, required String imageUrl}) {
    return Expanded(
      child: Card(
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
        child: Column(
          children: [
            ClipRRect(
              borderRadius: BorderRadius.vertical(top: Radius.circular(10)),
              child: Image.network(
                imageUrl,
                height: 100,
                width: double.infinity,
                fit: BoxFit.cover,
                errorBuilder: (context, error, stackTrace) {
                  return Container(
                    height: 100,
                    color: Colors.grey[300],
                    child: Icon(
                      Icons.broken_image,
                      size: 50,
                      color: Colors.grey,
                    ),
                  );
                },
              ),
            ),
            Padding(
              padding: EdgeInsets.all(10),
              child: Text(
                title,
                style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
