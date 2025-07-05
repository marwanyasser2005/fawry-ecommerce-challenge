# Fawry E-Commerce Challenge

This project is a Java console-based simulation of a simple e-commerce system, built for the **Fawry Rise Journey Full Stack Development Internship Challenge**.

---

## ✅ Features

* **Product Definition**

  * Name, Price, Quantity
* **Product Types**

  * Expirable + Shippable: Cheese, Biscuits
  * Non-Expirable + Shippable: TV, Milk
  * Non-Shippable: Fawry Card
* **Shipping**

  * Fixed shipping fee: 30 EGP (if total weight > 0kg)
  * Shippable products provide their weight (in kg)
* **Cart**

  * Add products with custom quantity (not more than available)
  * Reject invalid quantities
* **Checkout**

  * Prints: product list, shipment notice, total weight, subtotal, shipping, total, customer balance
  * Error shown if:

    * Cart is empty
    * Customer balance is insufficient

---

## 🛠️ How to Run

1. Compile the project:

   ```bash
   javac *.java
   ```

2. Run the app:

   ```bash
   java Main
   ```

---

## 💡 Sample Output

```
** Shipment notice **
2x Cheese 400g
1x Biscuits 700g
Total package weight 1.1kg

** Checkout receipt **
2x Cheese 200
1x Biscuits 150
--------------------
Subtotal 350
Shipping 30
Amount 380
Customer balance after payment: 620
```

---

# تحدي التجارة الإلكترونية - فوري

هذا المشروع عبارة عن محاكاة لنظام تجارة إلكترونية بسيط باستخدام لغة Java، تم تطويره لتلبية متطلبات **تحدي التدريب في Fawry Rise Journey**.

---

## ✅ المميزات

* **تعريف المنتج**

  * اسم، سعر، كمية
* **أنواع المنتجات**

  * قابلة للشحن وتنتهي صلاحيتها: Cheese, Biscuits
  * قابلة للشحن وغير منتهية: TV, Milk
  * غير قابلة للشحن: Fawry Card
* **نظام الشحن**

  * رسوم شحن ثابتة 30 جنيه عند وجود وزن
  * كل منتج قابل للشحن يحتوي على وزن بالكيلوجرام
* **السلة**

  * يمكن إضافة منتجات بكمية مخصصة لا تتعدى المتاحة
  * يتم رفض الكميات غير الصالحة
* **عند الدفع**

  * يتم طباعة تفاصيل المشتريات والوزن والفاتورة والرصيد
  * يتم إظهار خطأ في حال:

    * السلة فارغة
    * الرصيد غير كافٍ

---

## 🛠️ طريقة التشغيل

1. افتح الترمينال داخل ملف المشروع
2. اكتب:

   ```bash
   javac *.java
   java Main
   ```

---

## 💡 مثال من الإخراج

```
** Shipment notice **
2x Cheese 400g
1x Biscuits 700g
Total package weight 1.1kg

** Checkout receipt **
2x Cheese 200
1x Biscuits 150
--------------------
Subtotal 350
Shipping 30
Amount 380
Customer balance after payment: 620
```

---

**المشروع مكتوب بـ Java ويعتمد على مبادئ OOP وبدون مكتبات خارجية**
