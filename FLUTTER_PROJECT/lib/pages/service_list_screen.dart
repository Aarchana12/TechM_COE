import 'package:flutter/material.dart';
import 'service_detail_screen.dart';

class ServiceListScreen extends StatelessWidget {
  final List<Map<String, String>> services = [
    {
      "name": "Plumbing",
      "image":
          "https://image.freepik.com/free-vector/plumber-service-logo_90508-69.jpg",
      "description": "Fix leaks, install pipes, and more.",
    },
    {
      "name": "Electrician",
      "image":
          "https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX35744323.jpg",
      "description": "Electrical repairs, wiring, and installations.",
    },
    {
      "name": "Carpentry",
      "image":
          "https://static.vecteezy.com/system/resources/previews/000/425/760/non_2x/architect-foreman-engineering-construction-worker-vector-illustration-cartoon.jpg",
      "description": "Furniture repairs and custom woodwork.",
    },
    {
      "name": "Painting",
      "image":
          "https://nxbro.com/wp-content/uploads/2022/04/NX_Bro_residential_painting_services-removebg-preview.png",
      "description": "Home and commercial painting services.",
    },
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Services", style: TextStyle(fontWeight: FontWeight.bold)),
        backgroundColor: Colors.blueAccent,
      ),
      body: Padding(
        padding: EdgeInsets.all(16),
        child: GridView.builder(
          itemCount: services.length,
          gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
            crossAxisCount: 2,
            childAspectRatio: 0.8,
            crossAxisSpacing: 16,
            mainAxisSpacing: 16,
          ),
          itemBuilder: (context, index) {
            var service = services[index];

            return GestureDetector(
              onTap: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => ServiceDetailScreen(service: service),
                  ),
                );
              },
              child: Card(
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(15),
                ),
                elevation: 4,
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    ClipRRect(
                      borderRadius: BorderRadius.vertical(
                        top: Radius.circular(15),
                      ),
                      child: Image.network(
                        service["image"]!,
                        height: 100,
                        width: double.infinity,
                        fit: BoxFit.cover,
                      ),
                    ),
                    Padding(
                      padding: EdgeInsets.all(10),
                      child: Column(
                        children: [
                          Text(
                            service["name"]!,
                            style: TextStyle(
                              fontSize: 18,
                              fontWeight: FontWeight.bold,
                            ),
                          ),
                          SizedBox(height: 5),
                          Text(
                            service["description"]!,
                            style: TextStyle(color: Colors.grey[700]),
                            textAlign: TextAlign.center,
                          ),
                        ],
                      ),
                    ),
                  ],
                ),
              ),
            );
          },
        ),
      ),
    );
  }
}
