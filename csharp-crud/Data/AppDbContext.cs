using Microsoft.EntityFrameworkCore;
using CsharpCrud.Models;

namespace CsharpCrud.Data;

public class AppDbContext : DbContext
{
    public AppDbContext(DbContextOptions<AppDbContext> options)
        : base(options)
    {
    }

    public DbSet<Product> Products { get; set; } = null!;
} 