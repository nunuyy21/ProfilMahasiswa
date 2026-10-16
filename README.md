# Form Profil Mahasiswa - Jetpack Compose

Aplikasi Android sederhana ini dibuat untuk memenuhi tugas pembuatan **Form Profil Mahasiswa** menggunakan **Jetpack Compose** dengan menerapkan konsep *State*, *Event*, dan *Recomposition*.

## Fitur Aplikasi
- **Input Data Diri**: Kolom isian untuk Nama Lengkap, NIM, Program Studi, Semester, Email, dan Alamat.
- **State & Recomposition**: Menggunakan *State* agar input dari pengguna dapat langsung memperbarui komponen *Pratinjau Profil* secara otomatis secara *real-time* tanpa mengubah UI secara manual.
- **Tombol Aksi**: Tombol *Simpan Profil* untuk mengonfirmasi data dan tombol *Reset Form* untuk mengosongkan kembali kolom input.

## Refleksi Implementasi
Bagian yang paling menantang dalam pengerjaan tugas ini adalah memahami alur manajemen *state* dan *recomposition* di Jetpack Compose agar setiap perubahan input pada form dapat langsung terpantau dan merender ulang tampilan pratinjau di bawahnya dengan akurat.
