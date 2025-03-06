using System.ComponentModel.DataAnnotations;

namespace CsharpCrud.DTOs;

public class CreateProductDto
{
    [Required(ErrorMessage = "Nome é obrigatório")]
    public string Name { get; set; } = string.Empty;

    public string? Description { get; set; }

    [Required]
    [Range(0.01, double.MaxValue, ErrorMessage = "Preço deve ser maior que zero")]
    public decimal Price { get; set; }

    public int? Quantity { get; set; }
} 